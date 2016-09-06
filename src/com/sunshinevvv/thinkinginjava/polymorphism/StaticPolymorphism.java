package com.sunshinevvv.thinkinginjava.polymorphism;

/**
 * 只有非静态方法才会动态绑定
 * Created by 光 on 2016/9/6.
 */
class StaticSuper {
    public static String staticGet() {
        return "Base staticGet()";
    }

    public String dynamicGet() {
        return "Base dynamicGet()";
    }
}

class StaticSub extends StaticSuper {
    public static String staticGet() {
        return "Derived staticGet()";
    }

    public String dynamicGet() {
        return "Derived dynamicGet()";
    }
}

public class StaticPolymorphism {
    public static void main(String[] args) {
        StaticSuper sup = new StaticSub();
        // Upcast
        System.out.println(sup.staticGet());
        System.out.println(sup.dynamicGet());
    }

}