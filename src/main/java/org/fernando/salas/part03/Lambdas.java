package org.fernando.salas.part03;

import org.fernando.salas.part01.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

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

    public <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
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

        // 1, 2, 3, 4, 5
        forEach(Arrays.asList(1, 2, 3, 4, 5), System.out::println);

        // List Length: [7, 2, 6]
        List<Integer> list = map(Arrays.asList("lambdas", "in", "action"),
                (String s) -> s.length());
        System.out.println("List Length: " + list);

        Runnable o = () -> {
            System.out.println("ricky");
        };

        // Method References
        //ToIntFunction<String> stringToInt = (String s) -> Integer.parseInt(s);
        ToIntFunction<String> stringToInt = Integer::parseInt;

        //BiPredicate<List<String>, String> contains = (list2, element) -> list2.contains(element);
        BiPredicate<List<String>, String> contains = List::contains;


    }
}
