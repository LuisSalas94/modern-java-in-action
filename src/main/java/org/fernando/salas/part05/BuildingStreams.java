package org.fernando.salas.part05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BuildingStreams {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Modern", "Java", "In", "Action");

        Stream<String> stream = Stream.of("Modern", "Java", "In", "Action");

        // Stream from nullable
        String homeValue = System.getProperty("home");
        Stream<String> homeValueStream = homeValue == null ? Stream.empty() : Stream.of(homeValue);

        // Streams from Arrays
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println("Sum: " + sum);

        // * Streams from Functions
        // * Iterate
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // * Generate
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);


    }
}
