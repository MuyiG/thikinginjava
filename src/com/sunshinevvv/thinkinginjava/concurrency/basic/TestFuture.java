package com.sunshinevvv.thinkinginjava.concurrency.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestFuture {

    public static void main(String[] args) {
        testCancel();
    }


    private static void testCancel() {
        ExecutorService executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                5L, TimeUnit.SECONDS,
                new SynchronousQueue<>());
        Future<String> future = executorService.submit(() -> {
            System.out.println("Begin");
            try {
                TimeUnit.SECONDS.sleep(3L);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                return "CANCEL";
            }
            System.out.println("FINISH");
            return "OK";
        });

        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("cancel");
        boolean cancel = future.cancel(false); // 问题：这里为什么会cancel成功？
        System.out.println(cancel);
//        try {
//            System.out.println(future.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//

        executorService.shutdownNow();
    }
}
