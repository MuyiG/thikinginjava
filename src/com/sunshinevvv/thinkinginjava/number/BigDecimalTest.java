package com.sunshinevvv.thinkinginjava.number;

import java.math.BigDecimal;

/**
 * 简单结论：对于小数点后的精度比较重要的场景（比如：利率），要用BigDecimal。
 * 金额也未必要用BigDecimal，可以用分为单位来规避小数点问题。
 *
 * @author Gabriel Yang
 * @since 2020/7/20
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        /**
         * Why using BidDecimal?
         * For Precision.
         */
        double a = 0.02;
        double b = 0.03;
        double c = b - a;
        System.out.println(c); // 0.009999999999999998

        BigDecimal _a = new BigDecimal("0.02");
        BigDecimal _b = new BigDecimal("0.03");
        BigDecimal _c = _b.subtract(_a);
        System.out.println(_c); // 0.01
    }

}
