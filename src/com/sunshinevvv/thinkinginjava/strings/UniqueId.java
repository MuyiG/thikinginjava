package com.sunshinevvv.thinkinginjava.strings;

/**
 * Created by sunshine on 2017/3/24.
 */
public class UniqueId {
    public static void main(String[] args) {
        System.out.println("a=" + (int)'a' + ", z=" + (int)'z' + ", A=" + (int)'A' + ", Z=" + (int)'Z' + ", 0=" + (int)'0' + ", 9=" + (int)'9');

        System.out.println(generateUniqueId("H000001"));
        System.out.println(generateUniqueId("H000002"));

        System.out.println(generateUniqueId("B000001"));
        System.out.println(generateUniqueId("B000002"));

        System.out.println(generateUniqueId("X000001"));
        System.out.println(generateUniqueId("X000002"));

        System.out.println(generateUniqueId("H000262"));
        System.out.println(generateUniqueId("H000263"));
    }

    /**
     * 根据字符串生成唯一数字id，本方法仅仅适用于长度较短的字符串
     * @param s
     * @return
     */
    private static Long generateUniqueId(String s) {
        char[] charArr = s.toCharArray();
        Long result = 0L;
        int carry = 1;
        for (int i = 1; i < charArr.length; i++) {
            result += carry * (int) charArr[i];
            carry *= 11;
        }
        result += charArr[0];
        return result;
    }
}
