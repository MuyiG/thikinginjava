package com.sunshinevvv.thinkinginjava.concurrency.cooperation;

class NumberLock {
    boolean even;
}

public class PrintNumber2 {

    public static void main(String[] args) throws InterruptedException {
        NumberLock lock = new NumberLock();

        Thread t1 = new Thread(
                () -> {
                    for (int i = 0; i <= 10; i += 2) {
                        synchronized (lock) {
                            while (lock.even) {
                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println(Thread.currentThread().getName() + ":" + i);
                            lock.even = true;
                            lock.notify();
                        }
                    }
                }, "t1"
        );

        Thread t2 = new Thread(
                () -> {
                    for (int i = 1; i <= 10; i += 2) {
                        synchronized (lock) {
                            while (!lock.even) {
                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println(Thread.currentThread().getName() + ":" + i);
                            lock.even = false;
                            lock.notify();

                        }
                    }
                }, "t2"
        );
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
