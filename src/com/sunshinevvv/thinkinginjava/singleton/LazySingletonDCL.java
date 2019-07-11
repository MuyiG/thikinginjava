package com.sunshinevvv.thinkinginjava.singleton;

/**
 * 饱汉模式 + Double Check Lock，实现了资源的懒加载；同时注意使用 volatile 关键字来修饰单例实例。
 */
public class LazySingletonDCL {

    private static volatile LazySingletonDCL lazySingleton; // 这里使用 volatile 的目的是为了避免指令重排序，原因见下面

    private LazySingletonDCL() {
        System.out.println("LazySingletonSimple()");
    }

    public static LazySingletonDCL getInstance() {
        if (lazySingleton == null) {
            synchronized (LazySingletonSimple.class) {
                if (lazySingleton == null) {
                    /*
                     *  这行语句并不是一个原子操作，包括：1.分配内存 2.初始化内存 3.把实例指向内存 三步骤
                     *  JVM可能进行指令重排，把步骤3提前，这时候 lazySingleton 就被分配了值，但是内存还没有被初始化
                     *  加入恰好在此时，另一个线程进入 getInstance() 方法，就会拿到那个尚未被初始化完成的实例。
                     *  因此需要使用 volatile 修饰 lazySingleton 来避免指令重排
                     */
                    lazySingleton = new LazySingletonDCL();
                }
            }
        }
        return lazySingleton;
    }

}
