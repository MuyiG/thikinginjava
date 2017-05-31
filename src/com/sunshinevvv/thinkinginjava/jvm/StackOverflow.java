package com.sunshinevvv.thinkinginjava.jvm;

/**
 * VM参数：-verbose:gc -Xms20M -Xmx20M
 *
 * Created by sunshine on 2017/5/31.
 */
public class StackOverflow {
    private static final int _1MB = 1024 * 1024;

    private int stackLength = 0;

    public static void main(String[] args) {
        StackOverflow stackOOM = new StackOverflow();
        try {
            stackOOM.test();
        } catch (Throwable e) {
            System.out.println("Stack length: " + stackOOM.stackLength);
            throw e;
        }
    }

    private void test() {
        stackLength++;
//        byte[] bytes = new byte[_1MB];
        test();
    }

}
