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
    }
}
