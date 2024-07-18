package org.fernando.salas.part05;

import org.fernando.salas.part04.Dish;

import java.util.Arrays;
import java.util.List;



public class Slicing {
    public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .toList();
        // [Dish{name='seasonal fruit'}, Dish{name='prawns'}]
        System.out.println("Filtered Menu: " + filteredMenu);

        // Using Take-while: Returns, if this stream is ordered, a stream consisting of the longest
        // prefix of elements taken from this stream that match the given predicate.
        List<Dish> sliceMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .toList();
        // [Dish{name='seasonal fruit'}, Dish{name='prawns'}]
        System.out.println("Slice Menu: " + sliceMenu1);

    }
}
