package com.sunshinevvv.thinkinginjava.strings;

/**
 * （来自轮子哥的一篇知乎回答）交换字符串中的两个子串：
 * 给定一个字符串 s，交换两个子串 [i1, j1] 和 [i2, j2]，保证 j1 < j1 < i2 < j2。
 *
 * eg：给定 s = "a bc def gh"（实际没有空格，为了看起来更直观）,
 * 交换 [1, 2] 和 [3, 5] 后为："a def bc gh"
 */
public class ExchangeSubstring {

    public static void exchange(char[] s, int i1, int j1, int i2, int j2) {
        // s为每一个子串中元素个数，方便倒转时定位
        int s1 = i1, s2 = j1 - s1 + 1, s3 = i2 - j1 - 1, s4 = j2 - i2 + 1, s5 = s.length - j2 - 1;
        // 虽然reverse很多次，但复杂度依旧是O(n)
        reverse(s, i1, j2);
        reverse(s, 0, s.length - 1);
        reverse(s, s5, s5 + s2 - 1);
        reverse(s, s5 + s2, s5 + s2 + s3 - 1);
        reverse(s, s5 + s2 + s3, s5 + s2 + s3 + s4 - 1);
        reverse(s, 0, s.length - 1);
    }

    /**
     * 反转 [i, j] 子串
     */
    private static void reverse(char[] s, int i, int j) {
        char c;
        while (i < j) {
            c = s[i];
            s[i] = s[j];
            s[j] = c;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] s = "abcdefgh".toCharArray();
        exchange(s, 1,2, 3, 5);
        System.out.println(s);
        s = "abcdefgh".toCharArray();
        exchange(s, 1,2, 5, 6);
        System.out.println(s);
    }

}
