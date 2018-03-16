package com.sunshinevvv.thinkinginjava.common;

public class MathQuiz {
    public static void main(String[] args) {
        int k = 0;
        double s = 2;
        while (k < 2018) {
            s =  1.0 / (1.0 - s);
            k = k + 1;
        }
        System.out.println(s);
    }
}
