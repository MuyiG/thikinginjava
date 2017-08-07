package com.sunshinevvv.thinkinginjava.concurrency.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sunshine on 2017/8/7.
 */
public class ExceptionThread extends Thread {

    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new ExceptionThread());
    }
}
