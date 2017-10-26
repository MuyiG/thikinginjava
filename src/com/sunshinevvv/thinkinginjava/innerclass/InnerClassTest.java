package com.sunshinevvv.thinkinginjava.innerclass;

/**
 * Created by sunshine on 2017/10/15.
 */
public class InnerClassTest {
    public static void main(String[] args) {
        // 非静态InnerClass需要外部类实例才能创建：
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass a = outerClass.new InnerClass();
        OuterClass.ProtectedInnerClass b = outerClass.new ProtectedInnerClass();
        OuterClass.PublicInnerClass c = outerClass.new PublicInnerClass();

        // 无法直接创建，编译报错： is not an enclosing class
//        OuterClass.InnerClass a = new OuterClass.InnerClass();

        // NestedClass可以直接创建
        OuterClass.NestedClass d = new OuterClass.NestedClass();

        // AnotherClass的用法和普通类并无区别
        AnotherClass e = new AnotherClass();
    }
}
