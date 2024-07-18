package org.fernando.salas.part05;

import org.fernando.salas.part04.Dish;
import org.fernando.salas.part04.DishDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapping {
    public static List<Dish> menu = DishDemo.menu;

    public static void main(String[] args) {
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .toList();
        // [pork, beef, chicken, french fries, rice, season fruit, pizza, prawns, salmon]
        System.out.println("Dish Names: " + dishNames);

        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .toList();
        // [6, 4, 2, 6]
        System.out.println("Word Length: " + wordLengths);

        


    }
}
