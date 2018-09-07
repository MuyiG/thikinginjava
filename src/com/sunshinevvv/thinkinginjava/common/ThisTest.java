package com.sunshinevvv.thinkinginjava.common;

/**
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2011-2099</p>
 * <p>公   司： 口袋购物</p>
 * <p>其他说明：</p>
 * <p>作   者：杨光</p>
 * <p>完成日期：2018/9/7</p>
 */
public class ThisTest {
    public static void main(String[] args) {
        Parent c = new Child();
        c.g();
    }
}

class Parent {
    void f() {
        System.out.println("Parent f()");
    }

    void g() {
        // 这个语法的主要用途是：在内部类的方法中，要指定某个嵌套层次的外围类的“this”引用时，使用“外围类名.this”语法。
        // 对继承是不生效的，即使这么写，最终调的还是子类的f()
        Parent.this.f();
//        this.f();
    }
}

class Child extends Parent {
    void f() {
        System.out.println("Child f()");
    }
}