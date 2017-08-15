package com.sunshinevvv.thinkinginjava.concurrency.basic;

/**
 * Created by sunshine on 2017/7/26.
 */
public class SimpleThread extends Thread {
    private static int threadCount = 0;

    private int countDown = 5;

    public SimpleThread() {
        super(String.valueOf(++threadCount));
        start();
    }

    /**
     * 重写父类方法
     */
    public void run() {
        while (countDown > 0) {
            System.out.println("Thread" + getName() + ", countDown:" + countDown);
            countDown--;
            yield();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}
