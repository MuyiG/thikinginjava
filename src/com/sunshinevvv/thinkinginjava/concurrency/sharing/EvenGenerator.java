package com.sunshinevvv.thinkinginjava.concurrency.sharing;

public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    public int next() {
        ++currentEvenValue; // Danger point here!
        // 多线程执行时，可能会出现这样的情况：A线程只执行了第一个++，还没来得及执行完第二个，此时切换到另一个线程B执行两个++，此时线程B就会返回一个奇数。
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
