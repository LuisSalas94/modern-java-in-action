package org.fernando.salas.part05;

import org.fernando.salas.part04.Dish;
import org.fernando.salas.part04.DishDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        // ATTEMPT USING MAP AND ARRAYS.STREAM
        String[] arrayOfWords = {"Hello", "World"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
//        List<Stream<String>> letters = streamOfWords
//                .map(word -> word.split(""))
//                .map(Arrays::stream)
//                .distinct()
//                .toList();
        // [java.util.stream.ReferencePipeline$Head@10f87f48, java.util.stream.ReferencePipeline$Head@b4c966a]
        // System.out.println("Letters: " + letters);

        // flatmap: flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
        // Returns a stream consisting of the results of replacing each element of this stream
        // with the contents of a mapped stream produced by applying the provided mapping function to each element.
        List<String> uniqueCharacters = streamOfWords
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .toList();
        // [H, e, l, o, W, r, d]
        System.out.println("Unique Characters: " + uniqueCharacters);

        // Quiz 5.2
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = numbers.stream()
                .map(num -> num * num)
                .toList();
        // [1, 4, 9, 16, 25]
        System.out.println("Result: " + result);

        // Quiz: Given two lists of numbers, how would you return all pairs of numbers? For example,
        //given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4),
        //(3, 3), (3, 4)]. For simplicity, you can represent a pair as an array with two elements.

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j}))
                .toList();
        // [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]
        //pairs.forEach(pair -> System.out.println(Arrays.toString(pair)));

        // How would you extend the previous example to return only pairs whose sum is
        // divisible by 3
        List<int[]> pairs2 = numbers1.stream()
                .flatMap(i -> numbers2
                        .stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .toList();
        // [(2, 4), (3, 3)]
        pairs2.forEach(pair -> System.out.println(Arrays.toString(pair)));

    }
}
