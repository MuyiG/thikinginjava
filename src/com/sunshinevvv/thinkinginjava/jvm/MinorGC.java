package com.sunshinevvv.thinkinginjava.jvm;

/**
 * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * Created by 光 on 2017/3/30.
 */
public class MinorGC {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        testAllocation();
    }

    public static void testAllocation() {
        byte[] bytes1 = new byte[2 * _1MB];
        byte[] bytes2 = new byte[2 * _1MB];
        byte[] bytes3 = new byte[2 * _1MB];
        byte[] bytes4 = new byte[4 * _1MB];
//        byte[] bytes5 = new byte[4 * _1MB];
//        byte[] bytes6 = new byte[4 * _1MB];
//        byte[] bytes7 = new byte[4 * _1MB];
//        byte[] bytes8 = new byte[4 * _1MB];
//        byte[] bytes9 = new byte[4 * _1MB];
//        byte[] bytes10 = new byte[4 * _1MB];
    }

}
