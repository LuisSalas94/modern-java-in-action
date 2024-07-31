package org.fernando.salas.part10.cars;

public class Car {
    private Color color;
    private String brand;

    public Car(Color color, String brand) {
        this.color = color;
        this.brand = brand;
    }

    public Color getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }
}
