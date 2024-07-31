package org.fernando.salas.part10.cars;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.groupingBy;

public class CarDemo {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car(Color.BLUE, "Toyota"),
                new Car(Color.RED, "Ford"),
                new Car(Color.BLACK, "BMW"),
                new Car(Color.WHITE, "Tesla"),
                new Car(Color.RED, "Audi")
        );
        // group a list of cars, for example,first by their brand and then by their color
        Map<String, Map<Color, List<Car>>> carsByBrandAndColor =
                cars.stream().collect(groupingBy(Car::getBrand, groupingBy(Car::getColor)));
        System.out.println(carsByBrandAndColor);

    }
}
