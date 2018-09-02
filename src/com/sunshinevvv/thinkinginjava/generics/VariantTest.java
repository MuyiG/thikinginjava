package com.sunshinevvv.thinkinginjava.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的理解：泛型不支持协变是一种设计上的决策。
 * Java编译器可以选择支持泛型协变，但是一旦在编译期放过去了，运行期就再也无法区分了，所以没有选择支持；
 * 数组由于有完善的运行期检查，因此选择了编译期支持协变，运行时抛错的方式。
 */
public class VariantTest {
    public static void main(String[] args) {
        // Java数组是协变的，但是如果试图插入非法的类型时会抛RuntimeException
        Object[] objects = new Integer[10];
        objects[0] = 1;
//        objects[1] = "str"; // java.lang.ArrayStoreException: java.lang.String

        // Java泛型不是协变的，把抛错提前到了编译期
//        List<Object> objectList = new ArrayList<Integer>(); // Compile Error

        // 但可以使用通配符和上下界实现类似的效果
        List<?> list1 = new ArrayList<Integer>();
        List<? extends Number> list2 = new ArrayList<Integer>();
        List<? super Integer> list3 = new ArrayList<Number>();
    }
}
