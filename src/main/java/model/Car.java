package model;

import exception.ErrorMessage;

public class Car {

    private final String name;
    private int pos;

    public Car(String name) {
        validateName(name);

        this.name = name;
        pos = 0;
    }

    public void move(int randomNumber) {
        if (canMove(randomNumber)) {
            pos++;
        }
    }

    private boolean canMove(int randomNumber) {
        return randomNumber >= 4;
    }

    public int getPos() {
        return pos;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        validateEmptyName(name);
        validateOverLengthName(name);
    }

    private void validateEmptyName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME);
        }
    }

    private void validateOverLengthName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH);
        }
    }
}
