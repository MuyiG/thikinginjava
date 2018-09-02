package com.sunshinevvv.thinkinginjava.generics;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class EraseTest {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("string");
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        Class<?> strListClass = strList.getClass();
        Class<?> intListClass = intList.getClass();
        System.out.println("List<String> class:" + strListClass + ", element class:" + strList.get(0).getClass());
        System.out.println("List<Integer> class:" + intListClass + ", element class:" + intList.get(0).getClass());

        System.out.println("===");
        Erasure<String> erasure = new Erasure<>("hello");
        Class eclz = erasure.getClass();
        System.out.println("erasure class is:" + eclz.getName());
        for (Field f : eclz.getDeclaredFields()) {
            System.out.println("Field name " + f.getName() + " type:" + f.getType().getName());
        }
        for (Method method : eclz.getDeclaredMethods()) {
            System.out.println("Method :" + method);
        }

        System.out.println("===");
        IntegerErasure integerErasure = new IntegerErasure(1);
//        integerErasure.setObject("haha"); // compile error
        Erasure erasure1 = integerErasure;
        for (Method method : erasure1.getClass().getDeclaredMethods()) {
            System.out.println("Method :" + method);
        }
        erasure1.setObject("haha"); // 成功绕过编译期检查
        String s = (String) erasure1.getObject();
        System.out.println(s);

        Erasure[] erasures = new Erasure[10]; // OK
//        Erasure<String>[] erasures2 = new Erasure<String>[10]; // compile error
        Erasure<String>[] erasures3 = (Erasure<String>[]) new Erasure[10]; // work around
        erasures3[0] = new Erasure<>("");
//        erasures3[0] = new Erasure<>(1); // compile error
    }
}

class Erasure<T extends Comparable> {
    T object;

    public Erasure(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T t) {
        object = t;
    }
}

class IntegerErasure extends Erasure<Integer> {

    public IntegerErasure(Integer object) {
        super(object);
    }
}
