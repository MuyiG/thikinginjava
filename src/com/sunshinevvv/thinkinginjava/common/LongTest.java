package com.sunshinevvv.thinkinginjava.common;

/**
 * Created by sunshine on 2017/4/25.
 */
public class LongTest {
    public static void main(String[] args) {
//        Long l = Long.parseLong("998119023928672548840");

//        Map<String, Object> emptyMap = new HashMap<>();
//        long l1 = (Long)emptyMap.get(""); // NPE

        Long l2 = new Long(2L);
        Long l3 = new Long(2L);
        Integer integer = new Integer(2);
        System.out.println(l2 == l3);
        System.out.println(l2.equals(integer));
        System.out.println(l2.equals(2));
        System.out.println(l2.equals(2L));

        Long l = (Long) null;
        System.out.println(l);

        Long l4 = 11111L;
        Long l5 = 11111L;
        System.out.println(l4 == l5);
    }
}
