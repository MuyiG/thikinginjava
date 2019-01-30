package com.sunshinevvv.thinkinginjava.concurrency.basic;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(exec.submit(new SimpleCallable(i)));
        }
        for (Future<String> fs : result) {
            try {
                System.out.println(fs.get());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }
    }
}