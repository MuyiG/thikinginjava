package com.sunshinevvv.thinkinginjava.jvm;

/**
 * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=?
 *
 * Created by 光 on 2017/6/25.
 */
public class TenuringThreshold {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        testTenuringThreshold();
    }


    /**
     * 实测-XX:MaxTenuringThreshold=15，allocation1也会直接进入老年代，为什么呢？
     */
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB/ 4];    // 什么时候进入老年代取决于XX:MaxTenuringThreshold设置
        allocation2 = new byte[4 * _1MB];
        allocation2 = null;
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }
}
