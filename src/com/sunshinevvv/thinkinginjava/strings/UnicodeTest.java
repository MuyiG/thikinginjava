package com.sunshinevvv.thinkinginjava.strings;

public class UnicodeTest {

    public static void main(String[] args) {
        testUnicode();
//        testFilter();
    }

    private static void testUnicode() {
        String s1 = "你好";
        printInHex(s1);
        String s2 = "𡃁妹";
        System.out.println(s2.charAt(2)); // 不会报错，因为这个字符串实际上有3个char
        System.out.println(s2.charAt(s2.offsetByCodePoints(0, 1)));
        printInHex(s2);
        String s3 = "😝😢";
        printInHex(s3);
        String s4 = "ab";
        printInHex(s4);
        String s5 = "\uD86D\uDFD2";
        printInHex(s5);
        printInHex(s5.substring(1));
        String s6 = "🦖";
        printInHex(s6);
    }

    private static void printInHex(String s) {
        System.out.println("String: " + s + ", length: " + s.length());
        System.out.print("Code Points in hex: ");
        for (int i : s.codePoints().toArray()) {
            System.out.print(Integer.toHexString(i) + " ");
        }
        System.out.println();
        System.out.print("Characters in hex: ");
        for (char c : s.toCharArray()) {
//            System.out.print(Integer.toHexString(c) + " ");
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.print("UTF-8 bytes in hex: ");
        for (byte b : s.getBytes()) {
            System.out.print(String.format("%02x", b) + " ");
        }
        System.out.println();
        System.out.println("-----");
    }

}
