package com.zenikata.coding.rover;

import java.util.List;

public class Grid {

    public static final int GRID_SIZE = 10;
    private final List<Coordinates> obstacles;

    public Grid(List<Coordinates> obstacles) {
        this.obstacles = obstacles;
    }

    public boolean presentsObstacleAt(Coordinates coordinates) {
        return obstacles.contains(coordinates);
    }

    public Coordinates inDirection(final Coordinates position) {
        switch (position.getCompassDirection()) {
            case NORTH:
                return new Coordinates(position.getX(), (position.getY() + 1) % GRID_SIZE, CardinalDirection.NORTH);
            case EAST:
                return new Coordinates((position.getX() + 1) % GRID_SIZE, position.getY(), CardinalDirection.EAST) ;
            case SOUTH:
                return new Coordinates(position.getX(), (position.getY() - 1) % GRID_SIZE, CardinalDirection.SOUTH);
            case WEST:
                return new Coordinates((position.getX() - 1) % GRID_SIZE, position.getY(), CardinalDirection.WEST);
            default:
                throw new IllegalStateException("ZIZ IZ IMPOZIBLE");
        }
    }
}
