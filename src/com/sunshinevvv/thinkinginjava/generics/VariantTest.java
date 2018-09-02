package com.sunshinevvv.thinkinginjava.generics;

import java.util.ArrayList;
import java.util.List;

public class VariantTest {
    public static void main(String[] args) {
        // Java数组是协变的，但是运行时会抛错
        Object[] objects = new Integer[10];
        objects[0] = 1;
//        objects[1] = "str"; // java.lang.ArrayStoreException: java.lang.String

        // Java泛型不是协变的，把抛错提前到了编译期
//        List<Object> objectList = new ArrayList<Integer>(); // Compile Error

        List<String>[] strList = (List<String>[]) new ArrayList[10];
        strList[0] = new ArrayList<>();
        List[] list = strList;
        list[0] = new ArrayList<Integer>();
        list[0].add(1);
        list[0].add(1.1);
        list[0].add(" ");
    }
}
