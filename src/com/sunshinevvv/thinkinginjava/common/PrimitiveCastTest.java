package com.sunshinevvv.thinkinginjava.common;

/**
 * boolean不参与自动转换，其余基本类型运算时自动转换的规则是：
 *  if 有一个操作数为double，则转为double运算
 *  else if 有一个操作数为float，则转为float运算
 *  else if 有一个操作数为long，则转为long运算
 *  else 转为int运算（包括：byte, short, char三种情况）
 */
public class PrimitiveCastTest {
    public static void main(String[] args) {
        double d = 0.78;
        float f = 0.78F;
        long l = 100L;
        int i = 100;
        short s = 100;
        byte b = 127;
        char c = 12;
        System.out.println(getType(d * f));
        System.out.println(getType(l * d / i));
        System.out.println(getType(l * f));
        System.out.println(getType(l - i));
        System.out.println(getType(i + s));
        System.out.println(getType(s * b));
        System.out.println(getType(b + c));
    }

    public static String getType(Object o){
        return o.getClass().toString();
    }
}
