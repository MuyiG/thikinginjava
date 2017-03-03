package com.sunshinevvv.thinkinginjava.holding;

import java.util.Collections;
import java.util.LinkedList;

/**
 * LinkedList同时提供了Stack和Queue的接口。
 *
 * Created by sunshine on 2017/1/29.
 */
public class LinkedListFeatures {
    public static void main(String[] args) {
        LinkedList<String> pets = new LinkedList<>();
        Collections.addAll(pets, "Rat", "Manx", "Cymric", "Mutt", "Pug", "Cymric", "Pug");
        System.out.println("pets: " + pets);

        // 这三个方法基本相同，区别在于getFirst和element在列表为空时会抛异常，peek则会返回null
        System.out.println("getFirst() : " + pets.getFirst());
        System.out.println("element() : " + pets.element());
        System.out.println("peek() : " + pets.peek());

        // 同上，也是只有poll会返回null
        System.out.println("remove() : " + pets.remove());
        System.out.println("removeFirst() : " + pets.removeFirst());
        System.out.println("poll() : " + pets.poll());

        System.out.println("pets: " + pets);
        pets.addFirst("Hamster1");
        System.out.println("After addFirst: " + pets);

        // 这三个方法一样
        pets.offer("Hamster2");
        System.out.println("After offer: " + pets);
        pets.addLast("Hamster3");
        System.out.println("After addLast: " + pets);
        pets.add("Hamster4");
        System.out.println("After add: " + pets);
    }
}
