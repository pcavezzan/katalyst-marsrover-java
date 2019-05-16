package com.zenikata.coding.rover.cmd;

import com.zenikata.coding.rover.Command;
import com.zenikata.coding.rover.CommandException;
import com.zenikata.coding.rover.Coordinates;

class RotateLeft implements Command {

	private final Coordinates position;

	RotateLeft(final Coordinates position) {
		this.position = position;
	}

	@Override
	public Coordinates execute() throws CommandException {
		return this.position.atLeft();
	}
}
