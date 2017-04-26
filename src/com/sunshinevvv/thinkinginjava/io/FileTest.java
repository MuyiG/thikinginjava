package com.sunshinevvv.thinkinginjava.io;

import java.io.File;

/**
 * Created by sunshine on 2017/3/29.
 */
public class FileTest {
    public static void main(String[] args) {
        File file = new File("/Users/sunshine/Documents/test.amr");
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.getParentFile().getName());
        System.out.println(file.getAbsolutePath().replaceAll("\\.amr", "\\.mp3"));

        // 各种路径
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        System.out.println(FileTest.class.getClassLoader().getResource(""));
        System.out.println(ClassLoader.getSystemResource(""));
        System.out.println(FileTest.class.getResource(""));
        System.out.println(FileTest.class.getResource("/"));//Class文件所在路径
        System.out.println(new File("/").getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
    }
}
