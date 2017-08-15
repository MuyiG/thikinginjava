package com.sunshinevvv.thinkinginjava.concurrency.sharing;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock(); // 可重入锁

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " +
                    captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed(); // True -- lock is available
        al.timed(); // True -- lock is available
        // Now create a separate task to grab the lock:
        new Thread() {
            {
//                setDaemon(true); // 似乎没什么用，注释掉丝毫不影响结果
            }

            public void run() {
                al.lock.lock(); // 这行很有意思：内部类线程的run方法里，可以访问得到外部变量的私有成员属性。。
                System.out.println("acquired");
            }
        }.start();
        Thread.yield(); // yield没用，还是得sleep
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        al.untimed(); // False -- lock grabbed by task
        al.timed(); // False -- lock grabbed by task
    }
}
