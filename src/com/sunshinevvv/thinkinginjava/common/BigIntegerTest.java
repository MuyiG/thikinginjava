package com.sunshinevvv.thinkinginjava.common;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by sunshine on 2017/8/29.
 */
public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("355115018671761029363", 10); // radix=10可选，因为默认就是10进制
        System.out.println(bigInteger);

        BigDecimal b1 = new BigDecimal("14.9");
        System.out.println(b1.multiply(new BigDecimal("100")).longValue());
        System.out.println(b1.longValue() * 100); // 精度丢失
    }
}
