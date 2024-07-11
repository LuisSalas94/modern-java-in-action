package org.fernando.salas.part03;

import org.fernando.salas.part01.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambdas {
    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Hello");
        r.run();

        List<Apple> inventory = Arrays.asList(new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED));
        
        // [Apple{weight=80, color=GREEN}, Apple{weight=155, color=GREEN}]
        List<Apple> greenApples = filter(inventory, (Apple apple) -> Color.GREEN.equals(apple.getColor()));
        System.out.println(greenApples);

        Comparator<Apple> comparator = (Apple a1, Apple a2)
                -> a1.getWeight().compareTo(a2.getWeight());

        inventory.sort(comparator);
        // [Apple{weight=80, color=GREEN}, Apple{weight=120, color=RED}, Apple{weight=155, color=GREEN}]
        System.out.println(inventory);

    }
}
