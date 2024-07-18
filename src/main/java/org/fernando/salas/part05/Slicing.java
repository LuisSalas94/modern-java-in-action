package org.fernando.salas.part05;

import org.fernando.salas.part04.Dish;
import org.fernando.salas.part04.DishDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Slicing {
    public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        List<Dish> menu = DishDemo.menu;

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

        // USING DROPWHILE: Returns, if this stream is ordered, a stream consisting of the remaining
        // elements of this stream after dropping the longest prefix of elements that match the given
        // predicate.
        List<Dish> sliceMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .toList();
        // [Dish{name='rice'}, Dish{name='chicken'}, Dish{name='french fries'}]
        System.out.println("Slice Menu: " + sliceMenu2);

        // Truncating a stream
        List<Dish> dishes = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .toList();
        // [Dish{name='rice'}, Dish{name='chicken'}, Dish{name='french fries'}]
        System.out.println("Dishes: " + dishes);

        List<Dish> dishes2 = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .toList();
        // [Dish{name='french fries'}]
        System.out.println("Dishes: " + dishes2);

        // Quiz 5.1
        List<Dish> onlyMeat = menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .toList();
        // [Dish{name='pork'}, Dish{name='beef'}]
        System.out.println("Only Meat: " + onlyMeat);

    }
}
