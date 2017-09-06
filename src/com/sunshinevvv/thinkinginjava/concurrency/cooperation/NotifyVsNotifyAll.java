package com.sunshinevvv.thinkinginjava.concurrency.cooperation;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Blocker {
    synchronized void waitingCall() {
        try {
            while (!Thread.interrupted()) {
                wait();
                System.out.println(Thread.currentThread() + " awaken");
            }
        } catch (InterruptedException e) {
            // OK to exit this way
        }
    }

    synchronized void prod() {
        notify();
    }

    synchronized void prodAll() {
        notifyAll();
    }
}

class Task implements Runnable {
    static Blocker blocker = new Blocker();

    public void run() {
        blocker.waitingCall();
    }
}

class Task2 implements Runnable {
    // A separate Blocker object:
    static Blocker blocker = new Blocker();

    public void run() {
        blocker.waitingCall();
    }
}

public class NotifyVsNotifyAll {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Task());
        }
        exec.execute(new Task2());

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;

            public void run() {
                if (prod) {
                    System.out.println("notify() ");
                    Task.blocker.prod();
                    prod = false;
                } else {
                    System.out.println("notifyAll() ");
                    Task.blocker.prodAll();
                    prod = true;
                }
            }
        }, 0, 1000); // Run every 1 second

        TimeUnit.SECONDS.sleep(5); // Run for a while...
        timer.cancel();
        System.out.println("Timer canceled");

        TimeUnit.SECONDS.sleep(1);
        System.out.println("Task2.blocker.prodAll() ");
        Task2.blocker.prodAll();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("Shutting down");
        exec.shutdownNow(); // Interrupt all tasks
    }
}