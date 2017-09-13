package com.sunshinevvv.thinkinginjava.concurrency.components;

public class Fat {
    private volatile double d; // Prevent optimization
    private static int counter = 0;
    private final int id = counter++;

    public Fat() {
        // Expensive, interruptible operation:
        for (int i = 1; i < 10000; i++) {
            d += (Math.PI + Math.E) / (double) i;
        }
    }

    public String toString() {
        return "Fat" + id;
    }

}
