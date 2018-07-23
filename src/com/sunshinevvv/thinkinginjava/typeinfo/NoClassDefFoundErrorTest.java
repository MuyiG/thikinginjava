package com.sunshinevvv.thinkinginjava.typeinfo;

public class NoClassDefFoundErrorTest {
    public static void main(String[] args) {
        // 人工去删除编译后的Foo.class，然后再命令行运行：java com.sunshinevvv.thinkinginjava.typeinfo.NoClassDefFoundErrorTest，就会抛出NoClassDefFoundError
        Foo foo = new Foo();

        // 初始化失败会抛 NoClassDefFoundError
        InitErrorClass initErrorClass = new InitErrorClass();
    }
}

class InitErrorClass {
    static {
        int i = 1 / 0;
    }
}

class Foo {

}