package com.sunshinevvv.thinkinginjava.concurrency.cooperation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car {
    // 两个任务都关心的一个状态条件
    private boolean waxOn = false;

    // 修改waxOn状态，并通知wait的线程
    public synchronized void waxed() {
        waxOn = true; // Ready to buff
        notifyAll();
    }
    public synchronized void buffed() {
        waxOn = false; // Ready for another coat of wax
        notifyAll();
    }

    // 这两个wait的作用就是空等，直到自己关心的条件成立
    public synchronized void waitForWaxing() throws InterruptedException {
        while (!waxOn) {
            // wait一般写在一个while语句里，因为有可能wait被notifyAll唤醒之后，发现条件还不适合执行任务，这时候就需要继续wait
            wait();
        }
    }
    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn) {
            wait();
        }
    }
}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car c) {
        car = c;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + "Wax On! ");
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax On task");
    }
}

class WaxOff implements Runnable {

    private Car car;

    public WaxOff(Car c) {
        car = c;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + "Wax Off! ");
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax Off task");
    }
}

public class WaxOMatic {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(1); // Run for a while...
        exec.shutdownNow(); // Interrupt all tasks
    }
}