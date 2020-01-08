package com.sunshinevvv.thinkinginjava.typeinfo;

import com.sunshinevvv.thinkinginjava.common.BasicModel;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 反射
 */
public class ReflectionTest {

    private static <T> void getActualClass(T t) {
        Class<?> actualClass = t.getClass();
        System.out.println(actualClass.getCanonicalName());
    }

    private static <T> void getActualCollectionClass(Collection<T> collection) {
        Class c = collection.getClass();
        Type type = c.getGenericSuperclass();
        Type[] params = ((ParameterizedType) type).getActualTypeArguments();
        Class<?> actualClass = (Class) params[0];
        System.out.println(actualClass.getCanonicalName());
    }

    public static void main(String[] args) {
        getActualClass("");
        getActualClass(1);
        getActualClass(new BasicModel("name", 1));

        Collection<String> c = new ArrayList<String>() {};
        getActualCollectionClass(c);

        // 会报错：java.lang.ClassCastException: sun.reflect.generics.reflectiveObjects.TypeVariableImpl cannot be cast to java.lang.Class
        // WHY?
//        List<String> list = new ArrayList<>();
//        getActualCollectionClass(list);
    }

}
