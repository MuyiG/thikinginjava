package com.sunshinevvv.thinkinginjava.concurrency.cooperation;

public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        lock.wait(); // 抛出IllegalMonitorStateException，因为wait方法需要先获取对象的锁
    }
}
