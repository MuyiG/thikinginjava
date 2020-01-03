package com.sunshinevvv.thinkinginjava.polymorphism;

/**
 * 继承和内部类
 */
public class Foo {

    protected class Bar {
        protected Bar() {
            System.out.println("Foo.Bar");
        }
    }

    protected Bar bar;

    Foo() {
        System.out.println("Foo");
        bar = new Bar();
    }
}

class FooToo extends Foo {

    protected class Bar {
        protected Bar() {
            System.out.println("FooToo.Bar");
        }
    }

    protected Bar bar;

    public FooToo() {
        System.out.println("FooToo");
        bar = new Bar();
    }

    public static void main(String[] args) {
        new FooToo();
    }

}
