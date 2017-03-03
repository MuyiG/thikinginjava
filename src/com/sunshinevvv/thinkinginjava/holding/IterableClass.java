package com.sunshinevvv.thinkinginjava.holding;

import java.util.Iterator;

/**
 * Created by 光 on 2017/2/12.
 *
 * 实现了Iterable接口的类可用于foreach语法中，
 * 可用于foreach的不一定实现了Iterable接口，比如数组，但是可以用Arrays.asList来workaround。
 *
 */
public class IterableClass implements Iterable<String> {
    private String[] words = ("Adn that is how we know the Earth to be banana-shaped.").split(" ");

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
        };
    }

    public static void main(String[] args) {
        for (String s : new IterableClass()) {
            System.out.println(s);
        }
    }
}
