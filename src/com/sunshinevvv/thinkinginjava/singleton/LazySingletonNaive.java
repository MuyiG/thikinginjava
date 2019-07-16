package com.sunshinevvv.thinkinginjava.singleton;

/**
 * 基础饱汉模式，实现了资源的懒加载，但是有并发问题，只能在单线程环境下使用
 */
public class LazySingletonNaive {

    private static LazySingletonNaive instance;

    private LazySingletonNaive() {
        System.out.println("LazySingletonNaive()");
    }

    public static LazySingletonNaive getInstance() {
        if (instance == null) {
            instance = new LazySingletonNaive();
        }
        return instance;
    }

}
