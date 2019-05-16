package com.zenikata.coding.rover;

import com.zenikata.coding.rover.cmd.Commands;

public interface Command {

	Coordinates execute() throws CommandException;

	static Command create(String name, Coordinates position, Grid grid) {
		switch (name) {
			case "M":
				return Commands.newMoveForward(position, grid);

			case "R":
				return Commands.newRotateRight(position);

			case "L":
				return Commands.newRotateLeft(position);

			default:
				throw new IllegalArgumentException("Invalid command");
		}
	}

}
