package com.zenikata.coding.rover.cmd;

import com.zenikata.coding.rover.Command;
import com.zenikata.coding.rover.CommandException;
import com.zenikata.coding.rover.Coordinates;
import com.zenikata.coding.rover.Grid;

class MoveForward implements Command {

	private final Coordinates position;
	private final Grid grid;

	MoveForward(final Coordinates position, final Grid grid) {
		this.position = position;
		this.grid = grid;
	}

	@Override
	public Coordinates execute() throws CommandException {
		Coordinates potentialPosition = this.grid.inDirection(this.position);
		if (grid.presentsObstacleAt(potentialPosition)) {
			this.position.setBlockedByObstacle(true);
			throw new RoverBlockedByObstacleException();
		}

		return potentialPosition;
	}

	private static class RoverBlockedByObstacleException extends CommandException {
	}
}
