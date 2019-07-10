package com.sunshinevvv.thinkinginjava.exception;

import java.io.IOException;

/**
 * 演示异常堆栈
 */
public class TestStackTrace {
    private void fun1() throws IOException {
        throw new IOException("level 1 exception");
    }

    private void fun2() {
        try {
            fun1();
        } catch (IOException e) {
            throw new RuntimeException("level 2 exception", e);
        }
    }

    public static void main(String[] args) {
        try {
            new TestStackTrace().fun2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
