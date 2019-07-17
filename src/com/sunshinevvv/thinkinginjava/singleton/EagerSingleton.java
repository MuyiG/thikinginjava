package com.sunshinevvv.thinkinginjava.singleton;

/**
 * 普通模式，简单直接，依赖JVM的类初始化机制即可实现线程安全；<br/>
 * 个人感觉提前初始化不算什么缺点，牺牲一点启动速度来换取简洁和正确性是很值得的。[EJ Item 83] 也推荐这种模式，绝大多数情况下都用不到懒加载<br/>
 * 如果非要实现懒加载，可以参见 {@link LazySingletonNaive}, {@link LazySingletonDCL}, {@link LazySingletonHolder}
 */
public class EagerSingleton {

    private static final EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton() {
        System.out.println("EagerSingleton()");
    }

    // 问题：如果实例只在第一次调用该方法时初始化，那和懒加载有什么区别呢？
    public static EagerSingleton getInstance() {
        return eagerSingleton;
    }

}
