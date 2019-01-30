package com.sunshinevvv.thinkinginjava.concurrency.sharing;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Thread local storage is a mechanism that automatically creates different storage for the same variable, for each different thread that uses an object.
 *
 * Created by sunshine on 2017/8/15.
 */
class Accessor implements Runnable {
    private final int id;

    public Accessor(int idn) {
        id = idn;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    public String toString() {
        return "#" + id + ": " +
                ThreadLocalVariableHolder.get();
    }
}

public class ThreadLocalVariableHolder {
    // ThreadLocal objects are usually stored as static fields
    // 但这并非强制约束，直接使用非静态的成员变量也是OK的，只是静态变量无需拿到类的实例即可使用，会更方便一些。
    private static ThreadLocal<Integer> value =
            new ThreadLocal<>() {
                private Random rand = new Random(47);

                /**
                 * 为 ThreadLocal 变量赋初始值的标准写法
                 */
                protected synchronized Integer initialValue() {
                    return rand.nextInt(10000);
                }
            };

    public static void increment() {
        value.set(value.get() + 1);
    }

    public static int get() {
        return value.get();
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new Accessor(i));
        TimeUnit.SECONDS.sleep(3);  // Run for a while
        exec.shutdownNow();         // All Accessors will quit
    }
}
