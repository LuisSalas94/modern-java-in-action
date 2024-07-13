package org.fernando.salas.part03;

import java.util.function.Function;

public class Composing {
    public static void main(String[] args) {

        // andThen
//        Function<Integer, Integer> f = x -> x + 1;
//        Function<Integer, Integer> g = x -> x * 2;
//        Function<Integer, Integer> h = f.andThen(g);
//        int result = h.apply(3);
//        // Result: 8
//        System.out.println("Result: " + result);

        // compose
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.compose(g);
        int result = h.apply(1);
        // Result: 3
        System.out.println("Result: " + result);
    }
}
