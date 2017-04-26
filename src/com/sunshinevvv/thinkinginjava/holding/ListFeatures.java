package com.sunshinevvv.thinkinginjava.holding;

import java.util.*;

/**
 * Created by 光 on 2016/10/5.
 * 需要特别注意的是，对于subList所做的修改，都会同样作用于原List，可以参见Demo：SubList.java
 */
public class ListFeatures {
    public static void main(String[] args) {
        features();
        foreach();
    }

    private static void features() {
        Random rand = new Random(47);
        List<String> pets = new ArrayList<>();
        Collections.addAll(pets, "Rat", "Manx", "Cymric", "Mutt", "Pug", "Cymric", "Pug");
        System.out.println("1: " + pets);
        pets.add("Hamster"); // Automatically resizes
        System.out.println("2: " + pets);
        System.out.println("3: " + pets.contains("Hamster"));
        pets.remove("Hamster"); // Remove by object
        String p = pets.get(2);
        System.out.println("4: " + p + " " + pets.indexOf(p));
        String cymric = new String("Cymric");
        System.out.println("5: " + pets.indexOf(cymric));
        System.out.println("6: " + pets.remove(cymric));
        // Must be the exact object:
        System.out.println("7: " + pets.remove(p));
        System.out.println("8: " + pets);
        pets.add(3, "Mouse"); // Insert at an index
        System.out.println("9: " + pets);
        List<String> sub = pets.subList(1, 4);
        System.out.println("subList: " + sub);
        System.out.println("10: " + pets.containsAll(sub));
        Collections.sort(sub); // In-place sort
        System.out.println("sorted subList: " + sub);
        // Order is not important in containsAll():
        System.out.println("11: " + pets.containsAll(sub));
        Collections.shuffle(sub, rand); // Mix it up
        System.out.println("shuffled subList: " + sub);
        System.out.println("12: " + pets.containsAll(sub));
        List<String> copy = new ArrayList<>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<>(pets); // Get a fresh copy
        copy.remove(2); // Remove by index
        System.out.println("14: " + copy);
        copy.removeAll(sub); // Only removes exact objects
        System.out.println("15: " + copy);
        copy.set(1, "Mouse"); // Replace an element
        System.out.println("16: " + copy);
        copy.addAll(2, sub); // Insert a list in the middle
        System.out.println("17: " + copy);
        System.out.println("18: " + pets.isEmpty());
        pets.clear(); // Remove all elements
        System.out.println("19: " + pets);
        System.out.println("20: " + pets.isEmpty());
        Collections.addAll(pets, "Manx", "Cymric", "Rat", "EgyptianMau");
        System.out.println("21: " + pets);
        Object[] o = pets.toArray();
        System.out.println("22: " + o[3]);
        String[] pa = pets.toArray(new String[0]);
        System.out.println("23: " + pa[3]);
    }

    private static void foreach() {
        List<String> testList = new ArrayList<>();
        // 无输出
        for (String s : testList) {
            System.out.printf(s);
        }

        testList = null;
        // NPE
        for (String s : testList) {
            System.out.printf(s);
        }
    }
}
