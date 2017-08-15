package com.sunshinevvv.thinkinginjava.concurrency.basic;

/**
 * 基本的Thread和Runnable用法
 */
public class RunnableDemo implements Runnable {

    private String name;

    public RunnableDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + name + " running.");
        // 啥也不干，sleep1秒
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " " + name + " exiting.");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new RunnableDemo("Runnable-" + i), "Thread-" + i);
            thread.start();
        }
    }
}
