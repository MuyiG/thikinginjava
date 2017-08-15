package com.sunshinevvv.thinkinginjava.strings;

/**
 * Created by sunshine on 2017/8/14.
 */
public class SplitString {
    public static void main(String[] args) {
        String s1 = "13141";
        String s2 = "1231~342342";
        System.out.println(s1.split("~")[0]);
        System.out.println(s2.split("~")[0]);
    }
}
