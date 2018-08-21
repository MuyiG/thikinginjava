package com.sunshinevvv.thinkinginjava.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AppleFilter {
    private static List<Apple> filterGreenApples(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getColor().equals("Green")) {
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterApplesByColor(List<Apple> apples, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterApplesByWeight(List<Apple> apples, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getWeight() >= weight) {
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterApples(List<Apple> apples, ApplePredicate applePredicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (applePredicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();


        filterApples(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("Green") && apple.getWeight() >= 150;
            }
        });

        filterApples(apples, (Apple apple) -> apple.getColor().equals("Green") && apple.getWeight() >= 150);

        apples.sort(new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });

        apples.sort(Comparator.comparing(Apple::getWeight));
    }
}
