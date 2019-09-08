package com.sunshinevvv.thinkinginjava.strings;

/**
 * 检验subString的一些性质
 * Created by sunshine on 2017/2/22.
 */
public class SubString {
    public static void main(String[] args) {
        System.out.println(realSubString("😝😝😝啦啦", 0, 0));
        System.out.println(realSubString("😝😝😝啦啦", 0, 2));
        System.out.println(realSubString("😝😝😝啦啦", 0, 4));
        System.out.println(realSubString("😝😝😝啦啦", 0, 5));
    }

    private void testBasicSubString() {
        String s1 = "asdfghjkl";
        System.out.println(s1.substring(2, 5)); // dfg
        System.out.println(s1.substring(3)); //fghjkl
        System.out.println(s1.substring(3, s1.length())); // fghjkl
        System.out.println(s1.substring(0, s1.length() - 1)); // asdfghjk
        String s2 = "中文字符也只算一个";
        System.out.println(s2.substring(2, 4)); // 字符

        String s3 = "https://h5.daily.weidian.com/m/wenwen/article.html?aid=fdad5138&templateId=4";
        System.out.println(s3.substring(0, s3.lastIndexOf('/')));
    }


    public static String realSubString(String s, int begin, int end) {
        if (s == null) {
            throw new IllegalArgumentException("s is null.");
        }
        int codePointCount = s.codePointCount(0, s.length());
        if (begin < 0 || end < begin || end > codePointCount) {
            throw new IllegalArgumentException("index out of range.");
        }
        return s.substring(s.offsetByCodePoints(0, begin), s.offsetByCodePoints(0, end));
    }

}
