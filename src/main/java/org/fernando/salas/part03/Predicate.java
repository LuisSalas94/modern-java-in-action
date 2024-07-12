package org.fernando.salas.part03;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
