package org.fernando.salas.part02;

import org.fernando.salas.part01.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (predicate.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, Color.GREEN), new Apple(155, Color.GREEN),
                new Apple(180, Color.RED), new Apple(220, Color.RED));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Apple> greenApples = filterApplesByColor(inventory, Color.GREEN);
        // [Apple{weight=80, color=GREEN}, Apple{weight=155, color=GREEN}]
        System.out.println(greenApples);

        List<Apple> redApples = filterApplesByColor(inventory, Color.RED);
        // [Apple{weight=120, color=RED}]
        System.out.println(redApples);

        // Behavior parameterization
        // [Apple{weight=180, color=RED}, Apple{weight=220, color=RED}]
        List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());
        System.out.println(redAndHeavyApples);

        /*
        A light GREEN apple
        A heavy GREEN apple
        A heavy RED apple
        A heavy RED apple
        */
        prettyPrintApple(inventory, new AppleFancyFormatter());

        /*
        An apple of 80 g
        An apple of 155 g
        An apple of 180 g
        An apple of 220 g
        */
        prettyPrintApple(inventory, new AppleSimpleFormatter());

        // [Apple{weight=180, color=RED}, Apple{weight=220, color=RED}]
        List<Apple> redApples2 = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.RED.equals(apple.getColor());
            }
        });
        System.out.println(redApples2);

        // [Apple{weight=180, color=RED}, Apple{weight=220, color=RED}]
        List<Apple> result = filterApples(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));
        System.out.println(result);

        // [Apple{weight=180, color=RED}, Apple{weight=220, color=RED}]
        List<Apple> redApplesT = filter(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));
        System.out.println(redApplesT);

        // [2, 4, 6, 8, 10]
        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);
        System.out.println(evenNumbers);

    }
}
