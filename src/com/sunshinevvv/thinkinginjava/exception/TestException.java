package com.sunshinevvv.thinkinginjava.exception;

public class TestException {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {
        int x;
        try {
            System.out.println("try");
            x = 1;
            x = x / 0;
            return x;
        } catch (Exception e) {
            System.out.println("catch");
            x = 2;
            return x;
        } finally {
            System.out.println("finally");
            x = 3;
        }
    }
}
