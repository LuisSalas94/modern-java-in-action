package org.fernando.salas.part10;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class InternalDemo {
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("one", "two", "three");
//        numbers.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });
        //numbers.forEach(num -> System.out.println(num));
        numbers.forEach(System.out::println);
    }
}
