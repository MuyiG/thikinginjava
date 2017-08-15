package com.sunshinevvv.thinkinginjava.concurrency.sharing;

/**
 * 只有作用于一个对象的synchronized代码段才会互斥
 * Created by sunshine on 2017/8/15.
 */
class DualSynch {
    private Object syncObject = new Object();

    /**
     * 修饰方法时相当于synchronized(this)，语法糖？
     * synchronized不属于方法签名的一部分，所以下面的f()如果取消注释，编译器会报错。
     */
    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

//    public void f() {
//        synchronized (this) {
//            for (int i = 0; i < 5; i++) {
//                System.out.println("f()");
//                Thread.yield();
//            }
//        }
//    }

    public void g() {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}

public class SyncObject {
    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
        new Thread() {
            public void run() {
                ds.f();
            }
        }.start();
        ds.g();
    }
}