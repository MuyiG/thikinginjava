package com.sunshinevvv.thinkinginjava.typeinfo;

import java.util.Random;

class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws Exception {
        // Does not trigger initialization:
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFinal); // compile-time constant 不会触发初始化

        // Does trigger initialization:
        System.out.println(Initable.staticFinal2); // 不是compile-time constant，会触发初始化
        System.out.println(Initable.staticFinal2); // 不会初始化两次
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("com.sunshinevvv.thinkinginjava.typeinfo.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}
