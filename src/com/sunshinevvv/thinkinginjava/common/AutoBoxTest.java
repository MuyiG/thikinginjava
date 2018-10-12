package com.sunshinevvv.thinkinginjava.common;

public class AutoBoxTest {
    public static void main(String[] args) {
        Integer integer1 = 1;
        Integer integer2 = 1;
        System.out.println(integer1 == integer2);
        integer1 = 127;
        integer2 = 127;
        System.out.println(integer1 == integer2);
        integer1 = 128;
        integer2 = 128;
        System.out.println(integer1 == integer2);

    }
}
