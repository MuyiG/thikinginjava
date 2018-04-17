package com.sunshinevvv.thinkinginjava.containers;

import com.sunshinevvv.thinkinginjava.common.BasicModel;

import java.util.*;

/**
 * Created by 光 on 2016/10/4.
 * 简单结论就是：尽量用 Collections.addAll()和collection.addAll()
 * 不要用Arrays.asList(1, 2, 3, 4, 5)
 */
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));

        // Runs significantly faster, but you can’t construct a Collection this way:
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);

        // Produces a list "backed by" an array:
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99); // OK -- modify an element
        // list.add(21); // Runtime error because the underlying array cannot be resized.

        BasicModel basicModel = new BasicModel("Tom", 111);
        List<BasicModel> list1 = new ArrayList<>();
        List<BasicModel> list2 = new ArrayList<>();
        list1.add(basicModel);
        list2.addAll(list1);
        list2.get(0).setNo(222);
        System.out.println(list1.get(0).getNo());


    }
}
