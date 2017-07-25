package com.sunshinevvv.thinkinginjava.concurrency;

/**
 * Created by 光 on 2017/2/28.
 */
public class LiftOff implements Runnable {
    private static int num = 0;
    protected int countDown = 10;

    private final int id = num++;

    public void status() {
        System.out.println("#" + id + " " + (countDown > 0 ? countDown : "Lift off!"));
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            status();
        }
    }
}
