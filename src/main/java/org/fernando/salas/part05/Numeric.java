package org.fernando.salas.part05;

import org.fernando.salas.part04.Dish;
import org.fernando.salas.part04.DishDemo;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Numeric {
    public static final List<Dish> menu = DishDemo.menu;

    public static void main(String[] args) {
        //Numeric Streams
        //The problem with this code is that there’s an insidious boxing cost. Behind the scenes
        //each Integer needs to be unboxed to a primitive before performing the summation
        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("Calories: " + calories);

        // Primitive stream specializations
        int calories2 = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("Calories: " + calories2);

        // Converts a Stream to a numeric stream
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);

        // Converts the numeric stream to a Stream
        Stream<Integer> stream = intStream.boxed();

        // DEFAULT VALUES: OPTIONALINT
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        System.out.println("Max Calories: " + maxCalories);

        int max = maxCalories.orElse(1);
        System.out.println("Max: " + max);

        // Numeric Ranges
        IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        System.out.println("Count: " + evenNumbers.count());

    }
}
