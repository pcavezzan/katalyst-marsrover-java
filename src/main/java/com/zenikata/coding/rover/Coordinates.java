package com.zenikata.coding.rover;

public class Coordinates extends ValueObject {

    private final int x;
    private final int y;
    private final CardinalDirection compassDirection;

    Coordinates(int x, int y, final CardinalDirection compassDirection) {
        this.x = x;
        this.y = y;
        this.compassDirection = compassDirection;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    CardinalDirection getCompassDirection() {
        return compassDirection;
    }

    Coordinates atRight() {
        return new Coordinates(this.x ,this.y, this.compassDirection.atRight());
    }

    Coordinates atLeft() {
        return new Coordinates(this.x ,this.y, this.compassDirection.atLeft());
    }
}
