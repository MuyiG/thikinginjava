package com.sunshinevvv.thinkinginjava.strings;

/**
 * Created by sunshine on 2017/8/10.
 */
public class FormatString {
    public static void main(String[] args) {
        // 这种情况多余的参数会被忽略
        System.out.println(String.format("data:%s", "XX", "YY"));

        // 这种情况会抛异常
//        System.out.println(String.format("data:%s, data:%s", "XX"));
    }
}

