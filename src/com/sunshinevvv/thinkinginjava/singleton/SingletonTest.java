package com.sunshinevvv.thinkinginjava.singleton;

/**
 * 可以debug看一下各个方式构造函数调用的时机
 */
public class SingletonTest {

    public static void main(String[] args) {
        Singleton.getSomething();
        Singleton.getInstance();
        LazySingletonNaive.getInstance();
        LazySingletonDCL.getInstance();
        LazySingletonHolder.getInstance();
    }

}
