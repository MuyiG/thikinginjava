package com.sunshinevvv.thinkinginjava.strings;

/**
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2011-2099</p>
 * <p>公   司： 口袋购物</p>
 * <p>其他说明：</p>
 * <p>作   者：杨光</p>
 * <p>完成日期：2018/6/14</p>
 */
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
