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

        // Collections: External iteration using an iterator behind the scene
        List<String> names2 = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Dish dish = iterator.next();
            names2.add(dish.getName());
        }
        // [pork, beef, chicken, french fries, rice, season fruit, pizza, prawns, salmon]
        System.out.println("Name2: " + names2);

        // Streams: internal iteration
        List<String> names3 = menu.stream()
                .map(Dish::getName)
                .toList();
        // [pork, beef, chicken, french fries, rice, season fruit, pizza, prawns, salmon]
        System.out.println("Names3: " + names3);

        // Quiz 4.1 External vs. internal iteration
        List<String> highCaloricDishes = new ArrayList<>();
        Iterator<Dish> iteratorDish = menu.iterator();
        while (iteratorDish.hasNext()) {
            Dish dish = iteratorDish.next();
            if (dish.getCalories() > 300) {
                highCaloricDishes.add(dish.getName());
            }
        }
        // [pork, beef, chicken, french fries, rice, pizza, prawns, salmon]
        System.out.println("HighCaloricDishes: " + highCaloricDishes);

        List<String> highCaloricDishes2 = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .toList();
        // [pork, beef, chicken, french fries, rice, pizza, prawns, salmon]
        System.out.println("highCaloricDishes2: " + highCaloricDishes2);

        // Streams Operations
        List<String> names4 = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .toList();
        // [pork, beef, chicken]
        System.out.println("Names4: " + names4);
    }
}
