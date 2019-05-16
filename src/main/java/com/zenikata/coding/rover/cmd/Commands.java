package com.zenikata.coding.rover.cmd;

import com.zenikata.coding.rover.Command;
import com.zenikata.coding.rover.Coordinates;
import com.zenikata.coding.rover.Grid;

public final class Commands {
	private Commands() {
		// Factory class uninstanciable.
	}

	public static Command newMoveForward(final Coordinates position, final Grid grid) {
		return new MoveForward(position, grid);
	}

	public static Command newRotateLeft(final Coordinates position) {
		return new RotateLeft(position);
	}

	public static Command newRotateRight(final Coordinates position) {
		return new RotateRight(position);
	}

}
