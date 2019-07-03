package com.sunshinevvv.thinkinginjava.strings;

import java.nio.charset.StandardCharsets;

public class JavaChars {

    public static void main(String[] args) {
        testMessyCode();

//        testChars();

//        testSubString();

//        testFilter();
    }

    private static void testMessyCode() {
        String s = "好";
        byte[] bytes = s.getBytes(StandardCharsets.UTF_16BE);
        for (byte b : bytes) {
            System.out.print(Integer.toHexString(b & 0xFF) + " ");
        }
        System.out.println();
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }

    private static void testChars() {
        String s = "\uD86D\uDFD2"; // 𫟒
        System.out.println(s + ", length:" + s.length());
        for (char c : s.toCharArray()) {
            System.out.print(c + ", hex:");
            System.out.println(Integer.toHexString(c));
        }
    }

    private static void testSubString() {
        String s1 = "\uD86D\uDFD2小青童鞋"; // 𫟒小青童鞋
        System.out.println(s1.substring(0, 3));
        String s2 = "小青\uD86D\uDFD2童鞋"; // 小青𫟒童鞋
        System.out.println(s2.substring(0, 3));

        int end = s1.offsetByCodePoints(0, 3);
        System.out.println("real end:" + end);
        System.out.println(s1.substring(0, end));
    }

    private static void testFilter() {
        System.out.println(filterSurrogateCharacters("\uD86D\uDFD2小青童鞋"));
        System.out.println(filterSurrogateCharacters("哈哈"));
        System.out.println(filterSurrogateCharacters(""));
        System.out.println(filterSurrogateCharacters("哈🦖哈😝"));
        System.out.println(filterSurrogateCharacters("𡃁妹"));
        System.out.println(filterSurrogateCharacters("asdads\uD86D\uDFD2jkahskdjhakjsd"));
    }

    public static String filterSurrogateCharacters(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!Character.isSurrogate(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
