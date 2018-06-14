package com.sunshinevvv.thinkinginjava.strings;

public class CommonTest {
    public static void main(String[] args) {
        String s = "aaaa";
        s.replace("aa", "b");
        System.out.println(s);

        String n = null;
        if (n instanceof String) {
            System.out.println("null instanceof String");
        }
    }
}
