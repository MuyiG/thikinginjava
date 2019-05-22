package com.sunshinevvv.thinkinginjava.containers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTests {
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, "Value" + i);
        }
        System.out.println(map.values());

        testConcurrentModification();
    }

    private static void testConcurrentModification() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "OK");
        map.put(2, "OK");
        // 会抛出异常
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            map.put(3, "OK");
        }
    }

}