package model;

public class Car {

    private String name;
    private int pos;

    public Car(String name) {
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
}
