package com.sunshinevvv.thinkinginjava.strings;

/**
 * 比较不同的String创建方式，参考文章：http://www.importnew.com/10756.html
 */
public class DemoStringCreation {
    public static void main(String args[]) {
        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println("str1 and str2 are created by using string literal.");
        System.out.println("    str1 == str2 is " + (str1 == str2));
        System.out.println("    str1.equals(str2) is " + str1.equals(str2));

        String str3 = new String("Hello");
        String str4 = new String("Hello");
        System.out.println("str3 and str4 are created by using new operator.");
        System.out.println("    str3 == str4 is " + (str3 == str4));
        System.out.println("    str3.equals(str4) is " + str3.equals(str4));

        String str5 = "Hel" + "lo";
        String str6 = "He" + "llo";
        System.out.println("str5 and str6 are created by using string constant expression.");
        System.out.println("    str5 == str6 is " + (str5 == str6));
        System.out.println("    str5.equals(str6) is " + str5.equals(str6));

        String s = "lo";
        String str7 = "Hel" + s;
        String str8 = "He" + "llo";
        System.out.println("str7 is computed at runtime.");
        System.out.println("str8 is created by using string constant expression.");
        System.out.println("    str7 == str8 is " + (str7 == str8));
        System.out.println("    str7.equals(str8) is " + str7.equals(str8));
    }
}
