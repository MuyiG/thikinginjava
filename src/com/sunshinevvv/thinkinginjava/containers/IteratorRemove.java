package com.sunshinevvv.thinkinginjava.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 检验Java集合的fail fast机制
 */
public class IteratorRemove {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        // ConcurrentModificationException
//        for (Integer i : integerList) {
//            if (i == 3) {
//                integerList.remove(i);
//            }
//        }

        // 不会抛错，因为碰巧5是最后一个元素
        for (Integer i : integerList) {
            if (i == 5) {
                integerList.remove(i);
            }
        }
    }
}
