package com.sunshinevvv.thinkinginjava.strings;

public class CodePointTest {

    public static void main(String[] args) {
//        testUnicode();
        testCodePoint();
    }

    private static void testCodePoint() {
        printCodePoints("哈哈");
        printCodePoints("𡃁妹");
        printCodePoints("\uD86D\uDFD2");
        printCodePoints("😝😢");
    }

    private static void printCodePoints(String s) {
        int index = 0;
        System.out.print(s + ": ");
        while (index < s.length()) {
            int codePoint = Character.codePointAt(s, index);
            System.out.print(Integer.toHexString(codePoint) + " ");
            index += Character.offsetByCodePoints(s, index, 1);
        }
        System.out.println();
    }
}
