package org.fernando.salas.part06;

import org.fernando.salas.part04.Dish;
import org.fernando.salas.part04.DishDemo;


import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Reducing {
    public static final List<Dish> menu = DishDemo.menu;

    public static void main(String[] args) {

        long howManyDishes = menu.stream().collect(counting());
        System.out.println("howManyDishes: " + howManyDishes);

        long howManyDishes2 = menu.stream().count();
        System.out.println("howManyDishes2: " + howManyDishes);

        // Finding maximum and minimum in a stream of value
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCaloriesDish = menu.stream().collect(maxBy(dishCaloriesComparator));
        System.out.println("mostCaloriesDish: " + mostCaloriesDish);

        // Summarization
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println("totalCalories: " + totalCalories);

        double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println("avgCalories: " + avgCalories);

        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println("menuStatistics: " + menuStatistics);

        // IntSummaryStatistics Example
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics stats = numbers.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println("Numbers stats: " + stats);

        // Joining Strings
        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        // pork, beef, chicken, french fries, rice, season fruit, pizza, prawns, salmon
        System.out.println("ShortMenu: " + shortMenu);

        // Generalized summarization with reduction
        int totalCalories2 = menu.stream()
                .collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println("totalCalories2: " + totalCalories2);

        Optional<Dish> mostCaloriesDish2 = menu.stream()
                .collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println("mostCaloriesDish2: " + mostCaloriesDish2);

        int totalCalories3 = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        System.out.println("totalCalories3: " + totalCalories3);

        int totalCalories4 = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        System.out.println("totalCalories4: " + totalCalories4);

        int totalCalories5 = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("totalCalories5: " + totalCalories5);

        // Quiz 6.1: Joining strings with reducing
        String shortMenu2 = menu.stream().map(Dish::getName)
                .collect(reducing((s1, s2) -> s1 + s2)).get();
        System.out.println("shortMenu2: " + shortMenu2);

    }
}
