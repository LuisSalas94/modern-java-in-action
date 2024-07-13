package org.fernando.salas.part03;

import org.fernando.salas.part01.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting {
    public static class AppleComparator implements Comparator<Apple> {
        public int compare(Apple a1, Apple a2) {
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }

    public static void main(String[] args) {
        // 1
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.GREEN)));

        inventory.sort(new AppleComparator());

        // [Apple{weight=80, color=GREEN}, Apple{weight=120, color=GREEN}, Apple{weight=155, color=GREEN}]
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Apple(30, Color.GREEN));
        inventory.sort(new AppleComparator());
        // [Apple{weight=30, color=GREEN}, Apple{weight=80, color=GREEN}, Apple{weight=155, color=GREEN}]
        System.out.println(inventory);

        // Use an anonymous class
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });
        // [Apple{weight=30, color=GREEN}, Apple{weight=80, color=GREEN}, Apple{weight=155, color=GREEN}]
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Apple(20, Color.RED));
        inventory.sort(new AppleComparator());
        // [Apple{weight=20, color=RED}, Apple{weight=30, color=GREEN}, Apple{weight=155, color=GREEN}]
        System.out.println(inventory);

        // 3
        // Use lambda expressions
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        // [Apple{weight=20, color=RED}, Apple{weight=30, color=GREEN}, Apple{weight=155, color=GREEN}]
        System.out.println(inventory);

        // reshuffling things a little
        inventory.set(1, new Apple(10, Color.GREEN));
        // Use method references
        inventory.sort(Comparator.comparing(Apple::getWeight));
        // [Apple{weight=10, color=GREEN}, Apple{weight=20, color=RED}, Apple{weight=155, color=GREEN}]
        System.out.println(inventory);
    }
}
