package com.sunshinevvv.thinkinginjava.strings;

/**
 * 检验subString的一些性质
 * Created by sunshine on 2017/2/22.
 */
public class SubString {
    public static void main(String[] args) {
        String s1 = "asdfghjkl";
        System.out.println(s1.substring(2, 5)); // dfg
        System.out.println(s1.substring(3)); //fghjkl
        System.out.println(s1.substring(3, s1.length())); // fghjkl
        String s2 = "中文字符也只算一个";
        System.out.println(s2.substring(2, 4)); // 字符

        String s3 = "https://h5.daily.weidian.com/m/wenwen/article.html?aid=fdad5138&templateId=4";
        System.out.println(s3.substring(0, s3.lastIndexOf('/')));
    }
}
