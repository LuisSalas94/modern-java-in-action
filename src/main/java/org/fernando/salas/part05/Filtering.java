package org.fernando.salas.part05;

import org.fernando.salas.part04.Dish;
import org.fernando.salas.part04.DishDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filtering {
    public static final List<Dish> menu = DishDemo.menu;

    public static void main(String[] args) {
        List<Dish> vegetarianDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.isVegetarian()) {
                vegetarianDishes.add(dish);
            }
        }
        // [Dish{name='french fries'}, Dish{name='rice'}, Dish{name='season fruit'}, Dish{name='pizza'}]
        System.out.println("Vegetarian Dishes: " + vegetarianDishes);

        List<Dish> vegetarianDishes2 = menu.stream()
                .filter(Dish::isVegetarian)
                .toList();
        // [Dish{name='french fries'}, Dish{name='rice'}, Dish{name='season fruit'}, Dish{name='pizza'}]
        System.out.println("Vegetarian Dishes: " + vegetarianDishes2);

        // 2 4
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        


    }
}
