package com.sunshinevvv.thinkinginjava.common;

/**
 * null强转其他类型，不会报错，依旧为null
 */
public class NullCastTest {
    public static void main(String[] args) {
        BasicModel basicModel = (BasicModel) null;
        System.out.println(basicModel);
    }
}
