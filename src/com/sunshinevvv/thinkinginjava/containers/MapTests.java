package com.sunshinevvv.thinkinginjava.containers;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapTests {
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, "Value" + i);
        }
        System.out.println(map.values());
    }
}