package com.sunshinevvv.thinkinginjava.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunshine on 2017/5/26.
 */
public class ListForeach {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        List<List<String>> multiList = new ArrayList<>();
        multiList.add(Arrays.asList("a", "b"));
        multiList.add(Arrays.asList("c", "d"));
        multiList.add(Arrays.asList("e", "f"));
        for (List<String> temp : multiList) {
            System.out.println(temp);
        }

    }
}
