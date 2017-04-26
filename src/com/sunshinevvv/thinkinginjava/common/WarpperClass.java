package com.sunshinevvv.thinkinginjava.common;

/**
 * Created by sunshine on 2017/4/12.
 */
public class WarpperClass {
    public static void main(String[] args) {
        Integer integer = 2;
        int i = 2;
        System.out.println(integer == i); // true

        integer = null;
        i = integer; // NPE
    }
}
