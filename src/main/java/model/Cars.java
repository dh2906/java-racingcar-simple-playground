package model;

import java.util.ArrayList;
import java.util.List;

import exception.ErrorMessage;
import util.RandomGenerator;

public class Cars {

    private final List<Car> carList = new ArrayList<>();

    public void join(Car car) {
        validateDuplicateName(car);

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
            .orElse(0);
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

    public void validateDuplicateName(Car newCar) {
        boolean isDuplicate = carList.stream()
            .anyMatch(car ->
                car.getName()
                    .equals(newCar.getName())
            );

        if (isDuplicate) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME);
        }
    }
}
