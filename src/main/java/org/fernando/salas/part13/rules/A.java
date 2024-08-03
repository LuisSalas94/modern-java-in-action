package org.fernando.salas.part13.rules;

public interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}
