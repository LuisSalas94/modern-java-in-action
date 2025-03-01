package org.fernando.salas.part09;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LoggingDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
//        numbers.stream()
//                .map(num -> num + 17)
//                .filter(num -> num % 2 == 0)
//                .limit(3)
//                .forEach(System.out::println);

        List<Integer> result = numbers.stream()
                .peek(x -> System.out.println("from stream: " + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println("after map: " + x))
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("after filter: " + x))
                .limit(3)
                .peek(x -> System.out.println("after limit: " + x))
                .toList();
        System.out.println(result);
    }
}
