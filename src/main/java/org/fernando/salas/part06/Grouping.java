package org.fernando.salas.part06;

import org.fernando.salas.part04.Dish;
import org.fernando.salas.part04.DishDemo;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Grouping {

    public static final List<Dish> menu = DishDemo.menu;

    public enum CaloricLevel {DIET, NORMAL, FAT}

    public static void main(String[] args) {

        Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
                .collect(groupingBy(Dish::getType));
        // {FISH=[prawns, salmon], OTHER=[french fries, rice, season fruit, pizza],
        // MEAT=[pork, beef, chicken]
        System.out.println("dishesByType: " + dishesByType);

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
                .collect(groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }));
        // {NORMAL=[Dish{name='beef'}, Dish{name='french fries'}, Dish{name='pizza'}, Dish{name='salmon'}],
        // DIET=[Dish{name='chicken'}, Dish{name='rice'}, Dish{name='season fruit'}, Dish{name='prawns'}],
        // FAT=[Dish{name='pork'}]}
        System.out.println("dishesByCaloricLevel: " + dishesByCaloricLevel);

        // Manipulating grouped elements
        Map<Dish.Type, List<Dish>> caloricDishesByType = menu.stream()
                .collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 500, toList())));
        // {MEAT=[Dish{name='pork'}, Dish{name='beef'}], OTHER=[Dish{name='french fries'}, Dish{name='pizza'}]}
        System.out.println("caloricDishesByType: " + caloricDishesByType);

        Map<Dish.Type, List<String>> dishNamesByType = menu.stream()
                .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
        // {MEAT=[pork, beef, chicken], FISH=[prawns, salmon], OTHER=[french fries, rice, season fruit, pizza]}
        System.out.println("dishNamesByType: " + dishNamesByType);

        Map<Dish.Type, Long> typesCount = menu.stream()
                .collect(groupingBy(Dish::getType, counting()));
        // {MEAT=3, FISH=2, OTHER=4}
        System.out.println("TypesCount: " + typesCount);

        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));
        //  {MEAT=Optional[Dish{name='pork'}], FISH=Optional[Dish{name='salmon'}], OTHER=Optional[Dish{name='pizza'}]}
        System.out.println("Most Caloric Type: " + mostCaloricByType);

        // Finding the highest-calorie dish in each subgroup
        Map<Dish.Type, Dish> mostCaloricByType2 = menu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        // {MEAT=Dish{name='pork'}, FISH=Dish{name='salmon'}, OTHER=Dish{name='pizza'}}
        System.out.println("mostCaloricByType2: " + mostCaloricByType2);

        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream()
                .collect(groupingBy(Dish::getType, mapping(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }, toSet())));
        // {MEAT=[NORMAL, DIET, FAT], FISH=[NORMAL, DIET], OTHER=[NORMAL, DIET]}
        System.out.println("caloricLevelsByType: " + caloricLevelsByType);

    }
}
