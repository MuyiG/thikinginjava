package com.sunshinevvv.thinkinginjava.generics;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 关于泛型类型擦除的一些实验
 */
public class EraseTest {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("string");
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        Class<?> strListClass = strList.getClass();
        Class<?> intListClass = intList.getClass();
        System.out.println("List<String> class:" + strListClass);
        System.out.println("List<Integer> class:" + intListClass);
        System.out.println("Class equals? " + strListClass.equals(intListClass));

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
        erasure1.setObject("haha"); // 使用原始类型成功绕过编译期检查，但是不推荐该做法
        String s = (String) erasure1.getObject();
        System.out.println(s);
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
