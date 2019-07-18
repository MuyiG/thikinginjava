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

    /**
     * 问题：静态实例变量只在类初始化时执行初始化，而类初始化的时机就是 getInstance 方法的调用，那这和懒加载有什么区别呢？
     * 答：如果该类只有一个公开方法就是 getInstance，那么如此实现其实就是懒加载；
     *  但是如果还有其他公开的方法或者变量（比如下面的 getSomething)，则这种写法会在还没调用到 getInstance 时就触发了不必要的实例化。
     */
    public static EagerSingleton getInstance() {
        return eagerSingleton;
    }


    public static String getSomething() {
        return "Something";
    }

}
