package com.sunshinevvv.thinkinginjava.concurrency.basic;

/**
 * 效果约等于<code>SimpleThread</code>，语法略显复杂，但好处在于还可以继承别的父类（Java不支持多继承）。
 * Created by sunshine on 2017/7/26.
 */
public class SelfManaged implements Runnable {
    private int countDown = 5;
    private Thread t = new Thread(this);

    public SelfManaged() {
        t.start();
    }

    public String toString() {
        return Thread.currentThread().getName() + "(" + countDown + "), ";
    }

    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0)
                return;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            new SelfManaged();
    }
}
