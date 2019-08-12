package com.sunshinevvv.thinkinginjava.common;

public class NpeTest {

    private static void f(int i) {

    }

    public static void main(String[] args) {
        Integer integer = null;
        f(integer); // NPE
    }
}
