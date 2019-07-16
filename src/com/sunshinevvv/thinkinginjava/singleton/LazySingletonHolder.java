package com.sunshinevvv.thinkinginjava.singleton;

/**
 * 懒加载的推荐模式：利用JVM的 lazy class loading [JLS 12.4.1]。一个类只有在真正被用到的时候才会被初始化，此时才会初始化静态变量。<br/>
 * 而 Holder 类只有 getInstance 方法调用时才被真正使用到，此时触发初始化，为 instance 赋值，从而实现了懒加载。
 */
public class LazySingletonHolder {

    private static class Holder {
        static final LazySingletonHolder instance = new LazySingletonHolder();
    }

    private LazySingletonHolder() {
        System.out.println("LazySingletonHolder()");
    }

    public static LazySingletonHolder getInstance() {
        return Holder.instance;
    }

}
