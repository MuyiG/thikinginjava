package com.sunshinevvv.thinkinginjava.holding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sunshine on 2017/1/26.
 * 因为subList和原List共享同一个数组，所以对subList所做的全部修改都会同步映射到原List上。
 */
public class SubList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "a","b","c","d");
        List<String> subList = list.subList(1, 3);
        System.out.println("List:" + list + ", subList:" + subList);
        subList.set(0, "e");
        System.out.println("List:" + list + ", subList:" + subList);
        subList.add("f");
        System.out.println("List:" + list + ", subList:" + subList);
        list = list.subList(0, 3);
        System.out.println("List:" + list);
    }
}
