package com.sunshinevvv.thinkinginjava.concurrency;

/**
 * Created by 光 on 2017/2/28.
 */
public class LiftOff implements Runnable {
    private static int num = 0;
    private int countDown;

    private final int id = num++;

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public void status() {
        System.out.println(countDown > 0 ? countDown : "Lift off!");
    }

    @Override
    public void run() {
        while (countDown-- > 0) {

        }
    }
}
