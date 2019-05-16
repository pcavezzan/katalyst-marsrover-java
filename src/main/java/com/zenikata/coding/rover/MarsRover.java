package com.zenikata.coding.rover;

import java.util.Arrays;

class MarsRover {

    private Coordinates position;

    private Grid grid;
    private boolean blockedByObstacle;


    public MarsRover(Grid grid) {
        this.grid = grid;
        this.position = new Coordinates(0, 0, CardinalDirection.NORTH);
        this.blockedByObstacle = false;
    }

    public void execute(String commands) {

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
        } catch (RoverBlockedByObstacleException e) {
            System.out.println("Blocked by obstacle.");
            this.blockedByObstacle = true;
        }
    }

    private void moveForward() throws RoverBlockedByObstacleException {
        Coordinates potentialPosition = this.grid.inDirection(this.position);
        if (grid.presentsObstacleAt(potentialPosition)) {
            throw new RoverBlockedByObstacleException();
        }
        this.position = potentialPosition;
    }

    private void rotateLeft() {
        this.position = this.position.atLeft();
    }

    private void rotateRight() {
        this.position = this.position.atRight();
    }

    public String position() {
        return (this.blockedByObstacle ? "O:" : "")
                + this.position.getX() + ":"
                + this.position.getY() + ":"
                + this.position.getCompassDirection().getSymbol();
    }

    private static class RoverBlockedByObstacleException extends RuntimeException {
    }
}
