package org.fernando.salas.part06;

import org.fernando.salas.part04.Dish;
import org.fernando.salas.part04.DishDemo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;


public class Partitioning {
    public static final List<Dish> menu = DishDemo.menu;

    public enum CaloricLevel {DIET, NORMAL, FAT}

    public static boolean isPrime(int candidate) {
        return IntStream.range(2, candidate)
                .noneMatch(value -> candidate % value == 0);
    }

    public static void main(String[] args) {

        Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));
        // {false=[Dish{name='pork'}, Dish{name='beef'}, Dish{name='chicken'}, Dish{name='prawns'}, Dish{name='salmon'}], true=[Dish{name='french fries'}, Dish{name='rice'}, Dish{name='season fruit'}, Dish{name='pizza'}]}
        //System.out.println("partitionedMenu: " + partitionedMenu);

        List<Dish> vegetarianDishes = partitionedMenu.get(true);
        //System.out.println("vegetarianDishes: " + vegetarianDishes);

        List<Dish> nonVegetarianDishes = partitionedMenu.get(false);
        //System.out.println("nonVegetarianDishes: " + nonVegetarianDishes);

        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
        //System.out.println("vegetarianDishesByType: " + vegetarianDishesByType);

        // Collectors Class - Factory Methods
        List<Dish> dishes = menu.stream().collect(toList());
        System.out.println("Dishes: " + dishes);

        Set<Dish> dishSet = menu.stream().collect(toSet());
        System.out.println("dishSet: " + dishSet);

        Collection<Dish> dishCollection = menu.stream().collect(toCollection(ArrayList::new));
        System.out.println("dishCollection: " + dishCollection);

        long howManyDishes = menu.stream().collect(counting());
        System.out.println("howManyDishes: " + howManyDishes);

        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println("totalCalories: " + totalCalories);

        double avgCalories = menu.stream().collect(averagingDouble(Dish::getCalories));
        System.out.println("avgCalories: " + avgCalories);

        String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println("shortMenu: " + shortMenu);

        Optional<Dish> fattest = menu.stream().collect(maxBy(Comparator.comparingInt(Dish::getCalories)));
        System.out.println("fattest: " + fattest);

        int totalCalories2 = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        System.out.println("totalCalories2: " + totalCalories2);
    }
}
