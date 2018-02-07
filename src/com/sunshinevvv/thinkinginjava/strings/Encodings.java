package com.sunshinevvv.thinkinginjava.strings;

/**
 * 编码方式
 */
public class Encodings {
    public static void main(String[] args) {
        String str = "你好hello";
        int byte_len = str.getBytes().length;
        System.out.println("bytes:" + str.getBytes()[0]);
        int len = str.length();
        System.out.println("字节长度为：" + byte_len);
        System.out.println("字符长度为：" + len);
        System.out.println("系统默认编码方式：" + System.getProperty("file.encoding"));
    }
}
