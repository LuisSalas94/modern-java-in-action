package org.fernando.salas.part13.rules;

public interface B extends A {
    default void hello() {
        System.out.println("Hello from B");
    }
}
