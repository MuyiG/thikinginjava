package com.sunshinevvv.thinkinginjava.strings;

public class EmojiUtil {

    public static void main(String[] args) {
        System.out.println(filterPrivateCodePoint("直率的性子\uE022\uE022\uE022"));
        System.out.println(filterPrivateCodePoint("直率的性子😝"));
        System.out.println(filterPrivateCodePoint("直率的性子"));
    }

    public static String filterPrivateCodePoint(String source) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (inPrivateCodePoint(c)) {
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private static boolean inPrivateCodePoint(char c) {
        return c >= 0xe000 && c <= 0xe8fe;
    }
}
