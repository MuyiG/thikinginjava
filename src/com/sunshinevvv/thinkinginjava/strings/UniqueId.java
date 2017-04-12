package com.sunshinevvv.thinkinginjava.strings;

/**
 * Created by sunshine on 2017/3/24.
 */
public class UniqueId {
    public static void main(String[] args) {
        System.out.println("a=" + (int)'a' + ", z=" + (int)'z' + ", A=" + (int)'A' + ", Z=" + (int)'Z' + ", 0=" + (int)'0' + ", 9=" + (int)'9');

        System.out.println("H033=" + generateUniqueId("H033"));
        System.out.println("H323=" + generateUniqueId("H323"));
        System.out.println("H0023=" + generateUniqueId("H0023"));
        System.out.println("H0032=" + generateUniqueId("H0032"));
        System.out.println("H0034=" + generateUniqueId("H0034"));
        System.out.println("H00026=" + generateUniqueId("H00026"));
        System.out.println("H000186=" + generateUniqueId("H000186"));
        System.out.println("H00189=" + generateUniqueId("H00189"));
        System.out.println("H00190=" + generateUniqueId("H00190"));
        System.out.println("H00001=" + generateUniqueId("H00001"));
        System.out.println("H00289=" + generateUniqueId("H00289"));
        System.out.println("H00323=" + generateUniqueId("H00323"));
        System.out.println("H000289=" + generateUniqueId("H000289"));
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
