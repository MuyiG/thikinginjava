package com.sunshinevvv.thinkinginjava.concurrency.cooperation;

import java.util.concurrent.*;

class Producer implements Runnable {

    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String item = "hello";
            while (!Thread.interrupted()) {
                System.out.println(Thread.currentThread().getName() + " Produce: " + item);
                queue.add(item);
                TimeUnit.MILLISECONDS.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Producer interrupted, e:" + e);
        }
    }
}

class Consumer implements Runnable {

    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(Thread.currentThread().getName() + " Consume: " + queue.take());
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted, e:" + e);
        }
    }
}

/**
 * 多线程下的生产者-消费者模式，多对多
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(producer1);
        executorService.execute(producer2);
        executorService.execute(consumer1);
        executorService.execute(consumer2);
        executorService.execute(consumer3);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdownNow();
    }
}
