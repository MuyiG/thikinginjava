package com.sunshinevvv.thinkinginjava.concurrency.basic;

/**
 * Created by 光 on 2017/7/21.
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
