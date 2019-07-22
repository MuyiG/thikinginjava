package com.sunshinevvv.thinkinginjava.singleton;

/**
 * 简单懒加载模式，有并发问题，只能在单线程环境下使用
 */
public class LazySingletonNaive {

    private static LazySingletonNaive instance;

    private LazySingletonNaive() {
        System.out.println("LazySingletonNaive()");
    }

    public static synchronized LazySingletonNaive getInstance() {
        if (instance == null) {
            instance = new LazySingletonNaive();
        }
        return instance;
    }

}
