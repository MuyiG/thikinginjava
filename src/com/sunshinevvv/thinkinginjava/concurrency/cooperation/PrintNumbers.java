package com.sunshinevvv.thinkinginjava.concurrency.cooperation;

/**
 * 这里的两个方法可以不用同步，因为下面的两个线程保证了互斥访问
 */
class Number {
    private int value = 0;

    public void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }
}

class PrintOdd implements Runnable {

    private Number number;

    public PrintOdd(Number number) {
        this.number = number;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (number) {
                    if (number.getValue() >= 9) {
                        return;
                    }
                    while (number.getValue() % 2 != 0) {
                        number.wait();
                    }
                    number.increment();
                    System.out.println(Thread.currentThread().getName() + ": " + number.getValue());
                    number.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PrintEven implements Runnable {

    private Number number;

    public PrintEven(Number number) {
        this.number = number;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (number) {
                    if (number.getValue() >= 10) {
                        return;
                    }
                    while (number.getValue() % 2 == 0) {
                        number.wait();
                    }
                    number.increment();
                    System.out.println(Thread.currentThread().getName() + ": " + number.getValue());

                    number.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 让两个线程交替打印奇数和偶数，使用 wait-notify 机制
 */
public class PrintNumbers {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(new PrintEven(number), "PrintEven");
        Thread t2 = new Thread(new PrintOdd(number), "PrintOdd");
        t1.start();
        t2.start();
    }
}
