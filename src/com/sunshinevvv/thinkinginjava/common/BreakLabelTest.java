package com.sunshinevvv.thinkinginjava.common;

/**
 * Created by sunshine on 2017/10/25.
 */
public class BreakLabelTest {
    public static void main(String[] args) {
        lable:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(i + ", " + j);
                if (i == 2 && j == 1) {
                    break lable;
                }
            }
        }
        System.out.println("over!");
    }
}
