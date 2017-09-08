package com.sunshinevvv.thinkinginjava.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunshine on 2017/4/25.
 */
public class LongTest {
    public static void main(String[] args) {
//        Long l = Long.parseLong("998119023928672548840");

        Map<String, Object> emptyMap = new HashMap<>();
        long l1 = (Long)emptyMap.get(""); // NPE
    }
}
