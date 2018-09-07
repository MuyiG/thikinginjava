package com.sunshinevvv.thinkinginjava.common;

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