package com.sunshinevvv.thinkinginjava.init;

/**
 * 类初始化的顺序是先clinit再init。
 * clinit包含静态变量 + 静态初始化块，
 * init包含变量 + 初始化块 + 构造函数。
 */
public class InitOrder {
    // 静态变量 initializer for static filed
    public static String staticField = "静态变量";

    // 静态初始化块 static initializer
    static {
        System.out.println(staticField); // 如果这句话放在staticField定义之前会报错：illegal forward reference.
        System.out.println("静态初始化块");
    }

    // 变量 initializer for non-static filed
    public String field = "变量";

    // 初始化块 initializer
    {
        System.out.println(field);
        System.out.println("初始化块");
    }

    // 构造器
    public InitOrder() {
        System.out.println("构造器");
    }

    public static void staticMethod() {
        System.out.println("StaticMethod");
    }

    public static void main(String[] args) {
        // 静态方法的调用只会触发静态初始化
//        staticMethod();
        // 实例化会触发所有的初始化
        new InitOrder();
    }

}
