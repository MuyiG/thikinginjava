package com.sunshinevvv.thinkinginjava.arrays;

public class TestArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = a;
        b[1] = 4;
        System.out.println("a[1]:" + a[1] + ", b[1]:" +b[1]);
    }
}
