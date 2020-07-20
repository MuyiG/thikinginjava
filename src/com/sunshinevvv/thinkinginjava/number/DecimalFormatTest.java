package com.sunshinevvv.thinkinginjava.number;

import java.text.DecimalFormat;

public class DecimalFormatTest {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("000000"); // 几个0就代表不足几位的情况用0填充
        System.out.println(decimalFormat.format(1));
        System.out.println(decimalFormat.format(3.14));
        System.out.println(decimalFormat.format(666666));
        System.out.println(decimalFormat.format(123456789));

        decimalFormat = new DecimalFormat("0.###"); // 几个#就代表小数点后几位
        System.out.println(decimalFormat.format(1));
        System.out.println(decimalFormat.format(3.14));
        System.out.println(decimalFormat.format(666666));
        System.out.println(decimalFormat.format(123456789));
    }
}
