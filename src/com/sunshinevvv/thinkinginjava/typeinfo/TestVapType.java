package com.sunshinevvv.thinkinginjava.typeinfo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 探寻VAP不支持泛型返回值的原因
 */
public class TestVapType {
    /**
     * 这段代码是从vap-client里粘贴出来的
     * @param type
     * @return
     */
    private static String getType(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            Class<?> rawType = (Class) pt.getRawType();
            Type[] types = pt.getActualTypeArguments();
            if (Map.class.isAssignableFrom(rawType)) {
                return "Map<" + ((Class) types[0]).getSimpleName() + "," + ((Class) types[1]).getSimpleName() + ">";
            } else if (List.class.isAssignableFrom(rawType)) {
                return "List<" + ((Class) types[0]).getSimpleName() + ">";
            } else {
                if (types.length != 1) {
                    throw new IllegalStateException("un support parameterized type type with more than one actual types" + rawType);
                }
                Type first = types[0];
                if (first instanceof ParameterizedType) {
                    throw new IllegalStateException("un support nested parameterized type " + rawType);
                }
                return rawType.getSimpleName() + "<" + ((Class) first).getSimpleName() + ">";
            }
        } else {
            return ((Class) type).getSimpleName();
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        System.out.println(getType(map.getClass()));
        System.out.println(getType(Map.class));
    }
}
