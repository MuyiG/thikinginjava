package com.sunshinevvv.thinkinginjava.typeinfo.packageaccess;


import com.sunshinevvv.thinkinginjava.typeinfo.A;

class C implements A {
    public void f() {
        System.out.println("public C.f()");
    }

    public void g() {
        System.out.println("public C.g()");
    }

    void u() {
        System.out.println("package C.u()");
    }

    protected void v() {
        System.out.println("protected C.v()");
    }

    private void w() {
        System.out.println("private C.w()");
    }
}

public class HiddenC {
    // 方法可以声明返回C，但是外部还是无法使用C类型
    public static A makeA() {
        return new C();
    }
}