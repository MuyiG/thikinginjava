package com.sunshinevvv.thinkinginjava.concurrency.share;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEvenValue = new AtomicInteger(0);

    public int next() {
        currentEvenValue.addAndGet(2);
        return currentEvenValue.get();
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
