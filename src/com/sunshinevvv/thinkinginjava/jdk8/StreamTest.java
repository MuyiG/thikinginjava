package com.sunshinevvv.thinkinginjava.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        testStream();
    }

    public static void testStream() {
        List<String> s1 = new ArrayList<>();
        s1.add("a");
        s1.add("b");
        s1.add("c");
        List<String> s2 = s1.stream().filter(e -> e.equals("b")).collect(Collectors.toList());
        System.out.println(s1);
        System.out.println(s2);
    }
}
