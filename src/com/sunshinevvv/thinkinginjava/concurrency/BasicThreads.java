package com.sunshinevvv.thinkinginjava.concurrency;

/**
 * Created by 光 on 2017/7/21.
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
