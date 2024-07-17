package org.fernando.salas.part04;

import java.util.*;
import java.util.stream.Collectors;

public class DishDemo {
    public static final List<Dish> menu =
            Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
                    new Dish("beef", false, 700, Dish.Type.MEAT),
                    new Dish("chicken", false, 400, Dish.Type.MEAT),
                    new Dish("french fries", true, 530, Dish.Type.OTHER),
                    new Dish("rice", true, 350, Dish.Type.OTHER),
                    new Dish("season fruit", true, 120, Dish.Type.OTHER),
                    new Dish("pizza", true, 550, Dish.Type.OTHER),
                    new Dish("prawns", false, 400, Dish.Type.FISH),
                    new Dish("salmon", false, 450, Dish.Type.FISH));

    public static void main(String[] args) {
        // ! Java 7 code
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        // [Dish{name='rice'}, Dish{name='season fruit'}]
        // System.out.println("LowCaloricDishes: " + lowCaloricDishes);
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        // [Dish{name='season fruit'}, Dish{name='rice'}]
        // System.out.println("LowCaloricDishes: " + lowCaloricDishes);

        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }
        // [season fruit, rice]
        // System.out.println("LowCaloricDishesName: " + lowCaloricDishesName);

        // * Java 8
        List<String> lowCaloricDishesName2 =
                menu.stream()
                        .filter(d -> d.getCalories() < 400)
                        .sorted(Comparator.comparing(Dish::getCalories))
                        .map(Dish::getName)
                        .collect(Collectors.toList());
        // [season fruit, rice]
        System.out.println(lowCaloricDishesName2);

        List<String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .map(Dish::getName)
                        .limit(3)
                        .collect(Collectors.toList());

        // [pork, beef, chicken]
        System.out.println(threeHighCaloricDishNames);

        // Collections: External Iteration with a for-each loop
        List<String> names = new ArrayList<>();
        for (Dish dish : menu) {
            names.add(dish.getName());
        }
        // [pork, beef, chicken, french fries, rice, season fruit, pizza, prawns, salmon]
        System.out.println("Names: " + names);

        
    }
}
