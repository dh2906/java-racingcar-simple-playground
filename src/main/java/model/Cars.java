package model;

import util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public void join(Car car) {
        cars.add(car);
    }

    public void moveCars(int times) {
        for (int i = 0; i < times; i++) {
            cars.forEach(car ->
                    car.move(RandomGenerator.generate())
            );
        }
    }

    public int getWinnerPos() {
        return cars.stream()
                   .mapToInt(Car::getPos)
                   .max()
                   .getAsInt();
    }

    public List<Car> getWinners() {
        int maxPos = getWinnerPos();

        return cars.stream()
                .filter(car ->
                        car.getPos() == maxPos
                )
                .toList();
    }

}
