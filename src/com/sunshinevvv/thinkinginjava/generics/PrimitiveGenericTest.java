package com.sunshinevvv.thinkinginjava.generics;

/**
 * 基本类型会自动封箱为包装类型
 */
public class PrimitiveGenericTest {
    public static void main(String[] args) {
        BaseGeneric<Integer> baseGeneric = new BaseGeneric<>(1);
        System.out.println(baseGeneric);
    }
}
