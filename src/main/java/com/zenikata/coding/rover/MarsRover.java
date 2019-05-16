package com.zenikata.coding.rover;

import com.zenikata.coding.rover.cmd.MoveForward;
import com.zenikata.coding.rover.cmd.RotateLeft;
import com.zenikata.coding.rover.cmd.RotateRight;

import java.util.Arrays;

class MarsRover {

    private Coordinates position;
    private Grid grid;


    MarsRover(Grid grid) {
        this.grid = grid;
        this.position = new Coordinates(0, 0, CardinalDirection.NORTH);
    }

    void execute(String commands) {

        try {
            Arrays.stream(commands.split("")).forEach(command -> {
                switch (command) {
                    case "M":
                        moveForward();
                        break;
                    case "R":
                        rotateRight();
                        break;
                    case "L":
                        rotateLeft();
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid command");
                }
            });
        } catch (CommandException e) {
            System.out.println("Blocked by obstacle.");
        }
    }

    private void moveForward() throws CommandException {
        this.position = new MoveForward(this.position, this.grid).execute();
    }

    private void rotateLeft() throws CommandException{
        this.position = new RotateLeft(this.position).execute();
    }

    private void rotateRight() throws CommandException {
        this.position = new RotateRight(this.position).execute();
    }

    String position() {
        return (this.position.isBlockedByObstacle() ? "O:" : "")
                + this.position.getX() + ":"
                + this.position.getY() + ":"
                + this.position.getCompassDirection().getSymbol();
    }
}
