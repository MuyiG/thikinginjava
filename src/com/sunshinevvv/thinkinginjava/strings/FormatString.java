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

        formatHex();
    }

    private static void formatHex() {
        // 输出十六进制，用0补全到4位，结果是：001a
        System.out.println(String.format("%04x", 26));
    }
}

