package com.zenikata.coding.rover;

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
            Arrays.stream(commands.split("")).forEach(name -> {
            	final Command command = Command.create(name, position, grid);
            	this.position = command.execute();
            });
        } catch (CommandException e) {
            System.out.println("Blocked by obstacle.");
        }
    }


    String position() {
        return (this.position.isBlockedByObstacle() ? "O:" : "")
                + this.position.getX() + ":"
                + this.position.getY() + ":"
                + this.position.getCompassDirection().getSymbol();
    }
}
