package org.fernando.salas.part04;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsOps {
    public static final List<Dish> menu = DishDemo.menu;

    public static void main(String[] args) {
        List<String> names = menu.stream()
                .filter(dish -> {
                    System.out.println("filtering: " + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("Mapping: " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .toList();

        // [pork, beef, chicken]
        System.out.println("Names: " + names);
    }
}
