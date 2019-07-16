package com.sunshinevvv.thinkinginjava.singleton;

/**
 * 懒加载模式 + Double Check Lock，实现了资源的懒加载；同时注意使用 volatile 关键字来修饰单例实例。<br/>
 * JCIP 一书中已经不再推荐使用这种方式，可读性不够好，如果懒加载是必要的话，推荐使用 {@link LazySingletonHolder}<br/>
 * 但是并不意味着DCL一无是处，如果要懒加载一个成员变量（不要求单例），就可以使用 DCL + volatile。
 */
public class LazySingletonDCL {

    private static volatile LazySingletonDCL instance; // 这里使用 volatile 的目的是为了避免指令重排序，原因见下面

    private LazySingletonDCL() {
        System.out.println("LazySingletonDCL()");
    }

    public static LazySingletonDCL getInstance() {
        if (instance == null) {
            synchronized (LazySingletonNaive.class) {
                if (instance == null) {
                    /*
                     *  这行语句并不是一个原子操作，包括：1.分配内存 2.初始化内存 3.把实例指向内存 三个步骤
                     *  JVM可能进行指令重排，把步骤3提前，这时候 instance 就被分配了值，但是内存还没有被初始化
                     *  假如恰好在此时，另一个线程进入 getInstance() 方法，就会拿到那个尚未被初始化完成的实例。
                     *  因此需要使用 volatile 修饰 instance 来避免指令重排
                     */
                    instance = new LazySingletonDCL();
                }
            }
        }
        return instance;
    }

}
