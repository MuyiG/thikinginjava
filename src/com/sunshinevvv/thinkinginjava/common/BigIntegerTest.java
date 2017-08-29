package com.sunshinevvv.thinkinginjava.common;

import java.math.BigInteger;

/**
 * Created by sunshine on 2017/8/29.
 */
public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("355115018671761029363", 10); // radix=10可选，因为默认就是10进制
        System.out.println(bigInteger);
    }
}
