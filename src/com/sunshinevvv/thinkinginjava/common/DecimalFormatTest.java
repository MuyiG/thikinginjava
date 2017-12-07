package com.sunshinevvv.thinkinginjava.common;

import java.text.DecimalFormat;

/**
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2011-2099</p>
 * <p>公   司： 口袋购物</p>
 * <p>其他说明：</p>
 * <p>作   者：杨光</p>
 * <p>完成日期：2017/12/7</p>
 */
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
