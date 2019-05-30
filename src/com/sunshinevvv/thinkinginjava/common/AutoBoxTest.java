package com.sunshinevvv.thinkinginjava.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AutoBoxTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        testEqual();

        Integer integer1 = 1;
        Integer integer2 = 2;
        System.out.println(integer1 + ", " + integer2);
        swapInteger(integer1, integer2);
        System.out.println(integer1 + ", " + integer2);

        testContains();
    }

    private static void testEqual() {
        System.out.println("testEqual begin");
        int i = 2;
        Integer integer = 2; // Equivalent to : Integer.valueOf(2)
        Integer integer2 = 2;
        Integer integer3 = new Integer(2);
        System.out.println(integer == i); // true, auto-unboxing
        System.out.println(integer.equals(i)); // true, auto-unboxing
        System.out.println(integer3 == i); // true, auto-unboxing
        System.out.println(integer3.equals(i)); // true, auto-unboxing
        System.out.println(integer == integer2); // true, IntegerCache
        System.out.println(integer == integer3); // false, new Object
        System.out.println(integer.equals(integer3)); // true, compare value

        integer = 1024;
        i = 1024;
        integer2 = 1024;
        System.out.println(integer == i); // true, auto-unboxing
        System.out.println(integer == integer2); // false, IntegerCache
        System.out.println("testEqual end");
    }

    /**
     * 一种奇技淫巧，没啥实际用处，只是为了秀一下反射可以修改final的field
     */
    private static void swapInteger(Integer integer1, Integer integer2) throws NoSuchFieldException, IllegalAccessException {
        Integer temp = new Integer(integer1.intValue());
        Field value = integer1.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(integer1, integer2);
        Field value2 = integer2.getClass().getDeclaredField("value");
        value2.setAccessible(true);
        value2.set(integer2, temp);
    }

    private static void testContains() {
        System.out.println("testContains begin");
        List<Integer> integerList = new ArrayList<>();
        integerList.add(new Integer(1));
        integerList.add(2);
        System.out.println(integerList.contains(1));
        System.out.println(integerList.contains(new Integer(1)));
        System.out.println(integerList.contains(3));
        System.out.println("testContains end");
    }

}
