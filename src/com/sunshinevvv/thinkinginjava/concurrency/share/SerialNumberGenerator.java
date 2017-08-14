package com.sunshinevvv.thinkinginjava.concurrency.share;

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static /**synchronized*/ int nextSerialNumber() {
        return serialNumber++; // Not thread-safe，加上synchronized就好了
    }
}
