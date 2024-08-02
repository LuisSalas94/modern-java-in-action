package org.fernando.salas.part13;

import java.util.Arrays;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        List<Resizable> resizableShapes = Arrays.asList(new Square(), new Ellipse());
        Utils.paint(resizableShapes);
        System.out.println(resizableShapes);
    }
}
