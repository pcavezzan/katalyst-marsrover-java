package com.zenikata.coding.rover;

public class Coordinates extends ValueObject {

    private final int x;
    private final int y;
    private final CardinalDirection compassDirection;

    public Coordinates(int x, int y, final CardinalDirection compassDirection) {
        this.x = x;
        this.y = y;
        this.compassDirection = compassDirection;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CardinalDirection getCompassDirection() {
        return compassDirection;
    }

    public Coordinates atRight() {
        return new Coordinates(this.x ,this.y, this.compassDirection.atRight());
    }

    public Coordinates atLeft() {
        return new Coordinates(this.x ,this.y, this.compassDirection.atLeft());
    }
}
