package com.sunshinevvv.thinkinginjava.singleton;

/**
 * 饿汉模式，第一时间创建示例，避免后续并发问题；缺点是可能会造成资源浪费。
 */
public class EagerSingleton {

    private static final EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton() {
        System.out.println("EagerSingleton()");
    }

    public static EagerSingleton getInstance() {
        return eagerSingleton;
    }

}
