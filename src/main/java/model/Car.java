package model;

import util.RandomGenerator;

public class Car {

    private String name;
    private int pos;

    public Car(String name) {
        this.name = name;
        pos = 0;
    }

    public void move() {
        goForward(RandomGenerator.generate());
    }

    public void goForward(int randomNumber) {
        if (randomNumber >= 4) {
            pos++;
        }
    }

    public int getPos() {
        return pos;
    }
}
