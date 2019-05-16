package com.zenikata.coding.rover.cmd;

import com.zenikata.coding.rover.Command;
import com.zenikata.coding.rover.CommandException;
import com.zenikata.coding.rover.Coordinates;

class RotateRight implements Command {

	private final Coordinates position;

	RotateRight(final Coordinates position) {
		this.position = position;
	}

	@Override
	public Coordinates execute() throws CommandException {
		return this.position.atRight();
	}
}
