package org.fernando.salas.part05;

import org.fernando.salas.part04.Dish;
import org.fernando.salas.part04.DishDemo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reducing {

    public static final List<Dish> menu = DishDemo.menu;

    public static void main(String[] args) {
        // Summing the elements
        List<Integer> numbers = Arrays.asList(4, 5, 3, 9);
        int sum = 0;
        for (int x : numbers) {
            sum += x;
        }
        // 21
        System.out.println(sum);

        int sum2 = numbers.stream().reduce(0, (a, b) -> a + b);
        // 21
        System.out.println(sum2);

        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        // 540
        System.out.println(product);

        // No Initial value
        Optional<Integer> sum3 = numbers.stream().reduce((a, b) -> (a + b));
        // Optional[21]
        System.out.println(sum3);

        // Maximum and minimum
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("Max: " + max);

        Optional<Integer> mim = numbers.stream().reduce(Integer::min);
        System.out.println("Min: " + mim);

        // How would you count the number of dishes in a stream using the map and reduce methods?
        int count = menu.stream()
                .map(dish -> 1)
                .reduce(Integer::sum).get();
        System.out.println("Count: " + count);

        // How would you find the dish with the highest calories using stream operations?
        Optional<Integer> highest = menu.stream()
                .map(Dish::getCalories)
                .reduce(Integer::max);
        // Optional[800]
        System.out.println("Highest: " + highest);

        // How would you group the dishes by type using stream operations?
        Map<Dish.Type, List<Dish>> dishesTypes = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println("Dishes Types: " + dishesTypes);

        // How would you create a list of the names of all vegetarian dishes using stream operations?
        List<String> names = menu.stream()
                .filter(Dish::isVegetarian)
                .map(Dish::getName)
                .toList();
        // [french fries, rice, season fruit, pizza]
        System.out.println("Names: " + names);

        // How would you check if any dish has more than 1000 calories using stream operations?
        boolean dishWithMore1000Calories = menu.stream()
                .anyMatch(dish -> dish.getCalories() > 1000);
        // false
        System.out.println("dishWithMore1000Calories: " + dishWithMore1000Calories);

        // How would you create a list of the first three dishes that have more than 300 calories
        // using stream operations?
        Stream<Dish> firstThreeDishes = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3);
        // Dish{name='pork'} Dish{name='beef'} Dish{name='chicken'}
        firstThreeDishes.forEach(System.out::println);

        // How would you create a summary of the total calories
        // of all dishes using stream operations?
        int totalCalories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("Total Calories: " + totalCalories);

        // How would you partition the menu into vegetarian and non-vegetarian dishes using
        // stream operations?
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println("Vegetarian Dishes: " + partitionedMenu.get(true));
        System.out.println("Non-Vegetarian Dishes: " + partitionedMenu.get(false));



    }
}
