package com.sunshinevvv.thinkinginjava.resuing;

/**
 * Created by 光 on 2016/8/26.
 */
public class Frog extends Amphibian {
    public void foo() {
        System.out.println("Frog foo()");
    }

    public static void main(String[] args) {
        Amphibian amphibian = new Frog();
        amphibian.foo();
    }
}

class Amphibian {
    public void foo() {
        System.out.println("Amphibian foo()");
    }
}
