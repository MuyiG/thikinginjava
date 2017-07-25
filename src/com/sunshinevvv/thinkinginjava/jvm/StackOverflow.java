package com.sunshinevvv.thinkinginjava.jvm;

/**
 * VM参数：-verbose:gc -Xms20M -Xmx20M
 *
 * Created by sunshine on 2017/5/31.
 */
public class StackOverflow {
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
        test();
    }

}
