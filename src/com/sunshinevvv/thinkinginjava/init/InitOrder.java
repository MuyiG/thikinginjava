package com.sunshinevvv.thinkinginjava.init;

/**
 * 类初始化的顺序是先clinit再init。
 * clinit包含静态变量 + 静态初始化块，
 * init包含变量 + 初始化块 + 构造函数。
 */
public class InitOrder {
    // 静态变量
    public static String staticField = "静态变量";

    // 静态初始化块
    static {
        System.out.println(staticField); // 如果这句话放在staticField定义之前会报错：illegal forward reference.
        System.out.println("静态初始化块");
    }

    // 变量
    public String field = "变量";

    // 初始化块
    {
        System.out.println(field);
        System.out.println("初始化块");
    }

    // 构造器
    public InitOrder() {
        System.out.println("构造器");
    }

    public static void main(String[] args) {
        new InitOrder();
    }

}
