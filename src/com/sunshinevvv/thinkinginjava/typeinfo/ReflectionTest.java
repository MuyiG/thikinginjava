package com.sunshinevvv.thinkinginjava.typeinfo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * 反射
 */
public class ReflectionTest {

    class TestInterface implements Callable<String>, Comparable<Integer> {

        @Override
        public String call() {
            return null;
        }

        @Override
        public int compareTo(Integer o) {
            return 0;
        }

    }

    static class SubArrayList<E> extends ArrayList<E> {

    }

    private static void printSuperclass(Class<?> c) {
        Type superclass = c.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) superclass;
        System.out.println("superclass:" + parameterizedType.getTypeName());
    }

    private static void printInterfaces(Class<?> c) {
        Type[] types = c.getGenericInterfaces();
        System.out.println("interfaces:");
        for (Type type : types) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            System.out.println(parameterizedType.getTypeName());
        }
    }

    public static void main(String[] args) {
        SubArrayList<String> subArrayList = new SubArrayList<>();
        printSuperclass(subArrayList.getClass());
        printSuperclass(new ArrayList<String>() {}.getClass());
        printInterfaces(TestInterface.class);
    }

}
