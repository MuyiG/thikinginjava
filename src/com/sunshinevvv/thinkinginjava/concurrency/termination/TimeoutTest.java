package com.sunshinevvv.thinkinginjava.concurrency.termination;

import com.sunshinevvv.thinkinginjava.concurrency.basic.TaskWithResult;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class TimeoutTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Future<String>> futureList = executorService.invokeAll(Collections.singletonList(new TaskWithResult(1)), 50L, TimeUnit.MILLISECONDS);
        System.out.println(futureList.get(0).get());
    }
}
