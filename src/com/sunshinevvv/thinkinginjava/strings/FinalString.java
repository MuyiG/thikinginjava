package com.sunshinevvv.thinkinginjava.strings;

/**
 * Created by sunshine on 2017/10/30.
 */
public class FinalString {
    public static void main(String[] args) {
        String s1 = "Hello!";
        final String s2 = s1;
        String s3 = s1;
        s1 = "Hi!";
        System.out.println(s1 + ", " + s2 + ", " + s3); // 输出：Hi!, Hello!, Hello!
    }
}
