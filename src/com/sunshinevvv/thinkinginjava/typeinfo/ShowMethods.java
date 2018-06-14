package com.sunshinevvv.thinkinginjava.typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 反射的一个HelloWorld，输出一个类的所有方法（包括父类和接口里的）
 */
public class ShowMethods {

    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        String className = "com.sunshinevvv.thinkinginjava.typeinfo.ShowMethods";
        int lines;
        try {
            Class<?> c = Class.forName(className);
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            System.out.println("---Methods---");
            for (Method method : methods) {
                System.out.println(p.matcher(method.toString()).replaceAll(""));
            }
            System.out.println("---Constructors---");
            for (Constructor ctor : ctors) {
                System.out.println(p.matcher(ctor.toString()).replaceAll(""));
            }
            lines = methods.length + ctors.length;
            System.out.println("Total lines:" + lines);
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
}
