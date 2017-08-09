package com.sunshinevvv.thinkinginjava.concurrency.share;

/**
 * Created by sunshine on 2017/8/9.
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield(); // Cause failure faster
        // synchronized的缺点：无法处理中途发生的异常情况
//        Random random = new Random();
//        if (random.nextInt(10) < 3) {
//            throw new RuntimeException();
//        }
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
