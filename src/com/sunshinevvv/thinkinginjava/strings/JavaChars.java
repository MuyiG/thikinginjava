package com.sunshinevvv.thinkinginjava.strings;

public class JavaChars {

    public static void main(String[] args) {
//        testChars();

//        testSubString();

        testFilter();
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
        System.out.println(filterNonBMPCharacters("\uD86D\uDFD2小青童鞋"));
        System.out.println(filterNonBMPCharacters("哈哈"));
        System.out.println(filterNonBMPCharacters(""));
        System.out.println(filterNonBMPCharacters("哈🦖哈😝"));
        System.out.println(filterNonBMPCharacters("𡃁妹"));
        System.out.println(filterNonBMPCharacters("asdads\uD86D\uDFD2jkahskdjhakjsd"));
    }

    public static String filterNonBMPCharacters(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!Character.isSurrogate(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
