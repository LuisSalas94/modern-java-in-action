package org.fernando.salas.part03;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
