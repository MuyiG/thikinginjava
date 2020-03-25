package com.sunshinevvv.thinkinginjava.concurrency.basic;

import java.util.concurrent.TimeUnit;

/**
 * synchronized 关键字相关特性
 */
public class SynchronizedTest {

    private synchronized static void f1() {
        System.out.println(Thread.currentThread() + " f1");
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void f2() {
        System.out.println(Thread.currentThread() + " f2");
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(SynchronizedTest::f1, "thread1");
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        Thread t2 = new Thread(synchronizedTest::f2, "thread2");
        t1.start();
        t2.start();
        // 可以并行执行，可见类锁和实例锁并不互斥。
    }

}
