package org.fernando.salas.part05;

import org.fernando.salas.part04.Dish;
import org.fernando.salas.part04.DishDemo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Finding {
    public static final List<Dish> menu = DishDemo.menu;

    public static void main(String[] args) {
        // Checking to see if a predicate matches at least one element
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        // Checking to see if a predicate matches all elements
        boolean isHealthy = menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);
        System.out.println("is Healthy: " + isHealthy);

        // noneMath
        boolean isHealthy2 = menu.stream()
                .noneMatch(dish -> dish.getCalories() >= 1000);
        System.out.println("Is Healthy: " + isHealthy2);

        // Finding an element: findAny
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish1 -> System.out.println(dish1.getName()));

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();
        // Optional[9]
        System.out.println("firstSquareDivisibleByThree: " + firstSquareDivisibleByThree);

    }
}
