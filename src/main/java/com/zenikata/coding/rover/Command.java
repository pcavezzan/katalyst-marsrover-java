package com.zenikata.coding.rover;

public interface Command {

	Coordinates execute() throws CommandException;

}
