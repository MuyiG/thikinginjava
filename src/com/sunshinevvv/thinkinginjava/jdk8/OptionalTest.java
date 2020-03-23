package com.sunshinevvv.thinkinginjava.jdk8;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        try {
            Optional.of(null);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }

        Optional<Integer> optional1 = Optional.ofNullable(null);
        Optional<Integer> optional2 = Optional.ofNullable(1);

        testOptional(optional1);
        testOptional(optional2);
    }

    private static void testOptional(Optional<Integer> optional) {
        if (optional.isPresent()) {
            // 如果内容为空，get 方法会抛异常，因此必须结合 isPresent 使用
            System.out.println("optional value:" + optional.get());
        } else {
            System.out.println("optional value is null.");
        }
        // orElse 方法的含义是：如果内容非空，则返回内容；否则返回 other
        System.out.println(optional.orElse(0));
        // orElseGet 支持更复杂的 Lambda 写法
        System.out.println(optional.orElseGet(() -> {
            if (Math.random() < 0.5) {
                return -1;
            } else {
                return 0;
            }
        }));
    }

}
