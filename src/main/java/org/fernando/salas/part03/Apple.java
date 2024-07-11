package org.fernando.salas.part03;

import org.fernando.salas.part01.Color;

public class Apple {
    private int weight = 0;
    private Color color;

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color=" + color +
                '}';
    }
}
