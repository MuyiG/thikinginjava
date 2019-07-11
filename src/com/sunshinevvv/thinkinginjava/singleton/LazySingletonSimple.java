package com.sunshinevvv.thinkinginjava.singleton;

/**
 * 基础饱汉模式，实现了资源的懒加载，但是有并发问题
 */
public class LazySingletonSimple {

    private static LazySingletonSimple lazySingletonSimple;

    private LazySingletonSimple() {
        System.out.println("LazySingletonSimple()");
    }

    public static LazySingletonSimple getInstance() {
        if (lazySingletonSimple == null) {
            lazySingletonSimple = new LazySingletonSimple();
        }
        return lazySingletonSimple;
    }
}
