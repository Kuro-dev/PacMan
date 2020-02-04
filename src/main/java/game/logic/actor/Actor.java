package game.logic.actor;

import game.logic.area.field.Tile;
import game.logic.area.position.Coordinate;
import game.logic.area.position.Direction;

import java.util.List;

public abstract class Actor {
    protected final Coordinate coordinate;
    private final List<Tile> fieldTiles;

    public Actor(Coordinate coordinate, List<Tile> fieldTiles) {
        this.coordinate = coordinate;
        this.fieldTiles = fieldTiles;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Moves the actor to the given position, however checks if the position is free beforehand.
     *
     * @param xOffset    The x offset of which the actor is to be moved
     * @param yOffset    The y offset of which the actor is to be moved
     */
    public void moveSafely(int xOffset, int yOffset) {
        final Coordinate dest = this.coordinate.clone();
        dest.move(xOffset, yOffset);
        boolean peek = peek(dest);
        if (peek) {
            this.coordinate.move(xOffset, yOffset);
        }
    }

    public void moveSafely(Direction direction) {
        moveSafely(direction.getX(), direction.getY());
    }

    /**
     * Peaks at the given coordinates to find out what is there.
     *
     * @param dest The coordinate to peek at.
     * @return true if the given coordinate is a free space to walk on.
     */
    public boolean peek(Coordinate dest) {
        for (Tile tile : fieldTiles) {
            final boolean equal = tile.getCoordinate().equals(dest);
            if (equal) {
                return !tile.isWall();
            }
        }
        return false;
    }

    public boolean peek(int xOffset, int yOffset) {
        final Coordinate dest = this.coordinate.clone();
        dest.move(xOffset, yOffset);
        return peek(dest);
    }
}
