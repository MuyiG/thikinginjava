package com.sunshinevvv.thinkinginjava.concurrency.basic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * 简单线程池实现，源自：http://www.throwable.club/2019/07/15/java-concurrency-thread-pool-executor/
 */
public class SimpleThreadPoolExecutor implements Executor {

    private BlockingQueue<Runnable> workQueue;
    private static final AtomicInteger COUNTER = new AtomicInteger();
    private int coreSize;
    private int threadCount = 0;

    public SimpleThreadPoolExecutor(int coreSize) {
        this.coreSize = coreSize;
        this.workQueue = new LinkedBlockingQueue<>();
    }

    @Override
    public void execute(Runnable command) {
        if (++threadCount <= coreSize) {
            new Worker(command).start();
        } else {
            try {
                workQueue.put(command);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private class Worker extends Thread {
        private Runnable firstTask;

        public Worker(Runnable runnable) {
            super(String.format("Worker-%d", COUNTER.getAndIncrement()));
            this.firstTask = runnable;
        }

        @Override
        public void run() {
            Runnable task = this.firstTask;
            while (null != task || null != (task = getTask())) {
                try {
                    task.run();
                } finally {
                    task = null;
                }
            }
        }
    }

    private Runnable getTask() {
        try {
            return workQueue.take();
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void main(String[] args) {
        SimpleThreadPoolExecutor pool = new SimpleThreadPoolExecutor(5);
        IntStream.range(0, 10)
                .forEach(i -> pool.execute(() ->
                        System.out.println(String.format("Thread:%s,value:%d", Thread.currentThread().getName(), i))));
    }

}
