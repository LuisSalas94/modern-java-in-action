package org.fernando.salas.part09;

import org.fernando.salas.part04.Dish;

import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors.*;

import static java.util.stream.Collectors.*;

public class DishDemo {
    public static final List<Dish> menu = org.fernando.salas.part04.DishDemo.menu;

    public static void main(String[] args) {
        Map<Dish.CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
                .collect(groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                    else return Dish.CaloricLevel.FAT;
                }));
        // {DIET=[Dish{name='chicken'}, Dish{name='rice'}, Dish{name='season fruit'}, Dish{name='prawns'}], NORMAL=[Dish{name='beef'}, Dish{name='french fries'}, Dish{name='pizza'}, Dish{name='salmon'}], FAT=[Dish{name='pork'}]}
        System.out.println(dishesByCaloricLevel);

        Map<Dish.CaloricLevel, List<Dish>> dishesByCaloricLevel2 = menu
                .stream().collect(groupingBy(Dish::getCaloricLevel));
        // {DIET=[Dish{name='chicken'}, Dish{name='rice'}, Dish{name='season fruit'}, Dish{name='prawns'}], NORMAL=[Dish{name='beef'}, Dish{name='french fries'}, Dish{name='pizza'}, Dish{name='salmon'}], FAT=[Dish{name='pork'}]}
        System.out.println(dishesByCaloricLevel2);

        int totalCalories = menu.stream().map(Dish::getCalories).reduce(0, (c1, c2) -> c1 + c2);
        // 4300
        System.out.println(totalCalories);
        // 4300
        int totalCalories2 = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(totalCalories2);

        // Imperative data processing
        List<String> dishNames = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() > 300) {
                dishNames.add(dish.getName());
            }
        }
        // [pork, beef, chicken, french fries, rice, pizza, prawns, salmon]
        System.out.println(dishNames);

        // Streams API
        List<String> dishNames2 = menu.parallelStream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .toList();
        // [pork, beef, chicken, french fries, rice, pizza, prawns, salmon]
        System.out.println(dishNames2);
    }
}
