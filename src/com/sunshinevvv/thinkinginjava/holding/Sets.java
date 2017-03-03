package com.sunshinevvv.thinkinginjava.holding;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by 光 on 2016/10/5.
 */
public class Sets {

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> treeSet = new TreeSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();

        for (int i = 0; i < 20 ; i++) {
            hashSet.add(String.valueOf(i));
            treeSet.add(String.valueOf(i));
            linkedHashSet.add(String.valueOf(i));
        }

        System.out.println("HashSet: " + hashSet);
        System.out.println("TreeSet: " + treeSet);
        System.out.println("LinkedHashSet: " + linkedHashSet);
    }
}
