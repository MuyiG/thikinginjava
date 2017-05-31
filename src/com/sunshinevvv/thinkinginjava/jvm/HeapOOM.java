package com.sunshinevvv.thinkinginjava.jvm;

/**
 * VM参数：-verbose:gc -Xms20M -Xmx20M
 *
 * Created by sunshine on 2017/5/31.
 */
public class HeapOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        new HeapOOM().test();
    }

    private void test() {
        byte[] bytes1 = new byte[10 * _1MB];
        byte[] bytes2 = new byte[10 * _1MB];
        byte[] bytes3 = new byte[10 * _1MB];
    }

}
