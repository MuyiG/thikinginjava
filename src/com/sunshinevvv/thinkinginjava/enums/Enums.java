package com.sunshinevvv.thinkinginjava.enums;

import java.util.Random;

/**
 * Created by sunshine on 2017/9/18.
 */
public class Enums {
    private static Random rand = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }
    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}
