package org.fernando.salas.part09.strategy;

public class IsNumeric implements ValidationStrategy{

    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
