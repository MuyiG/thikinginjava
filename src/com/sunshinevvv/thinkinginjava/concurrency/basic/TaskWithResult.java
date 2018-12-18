package com.sunshinevvv.thinkinginjava.concurrency.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        try {
            TimeUnit.MILLISECONDS.sleep(100L);
        } catch (InterruptedException e) {
//            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        return "Result of TaskWithResult " + id;
    }
}
