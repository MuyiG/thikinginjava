package com.sunshinevvv.thinkinginjava.concurrency.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SimpleCallable implements Callable<String> {

    private int id;

    public SimpleCallable(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        try {
            TimeUnit.MILLISECONDS.sleep(100L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Result of SimpleCallable " + id;
    }
}
