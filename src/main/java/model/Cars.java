package model;

import util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList = new ArrayList<>();

    public void join(Car car) {
        carList.add(car);
    }

    public void moveCars() {
        carList.forEach(car ->
            car.move(RandomGenerator.generate())
        );
    }

    public int getWinnerPos() {
        return carList.stream()
            .mapToInt(Car::getPos)
            .max()
            .getAsInt();
    }

    public List<Car> getWinners() {
        int maxPos = getWinnerPos();

        return carList.stream()
            .filter(car ->
                car.getPos() == maxPos
            )
            .toList();
    }

    public List<Car> getCarList() {
        return carList;
    }
}
