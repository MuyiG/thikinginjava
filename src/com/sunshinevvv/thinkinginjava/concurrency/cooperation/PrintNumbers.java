package com.sunshinevvv.thinkinginjava.concurrency.cooperation;

/**
 * 让两个线程交替打印奇数和偶数，使用 wait-notify 机制
 */
public class PrintNumbers {

    private static int i = 0;
    private static final Object o = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                while (true) {
                    synchronized (o) {
                        if (i >= 10) {
                            break;
                        }
                        while (i % 2 == 0) {
                            o.wait();
                        }
                        i++;
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                        o.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "PrintEven");

        Thread t2 = new Thread(() -> {
            try {
                while (true) {
                    synchronized (o) {
                        if (i >= 9) {
                            break;
                        }
                        while (i % 2 != 0) {
                            o.wait();
                        }
                        i++;
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                        o.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "PrintOdd");
        t1.start();
        t2.start();
    }

}
