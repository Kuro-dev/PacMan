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
     * Moves the actor to the given position, if possible. Character will not move if not.
     *
     * @param xOffset The x offset of which the actor is to be moved
     * @param yOffset The y offset of which the actor is to be moved
     */
    public void moveSafely(int xOffset, int yOffset) {
        final Coordinate dest = this.coordinate.copy();
        dest.move(xOffset, yOffset);
        boolean peek = peek(dest);
        if (peek) {
            move(xOffset, yOffset);
        }
    }

    public void move(Direction direction) {
        move(direction.getX(), direction.getY());
    }

    /**
     * Moves the actors position by the given offset.
     * <p>Care should be taken when invoking this method as it does not check whether or not it is safe to move.</p>
     * <p>In most cases {@link #moveSafely(Direction)} or {@link #moveSafely(int, int)} should be used instead</p>
     *
     * @param xOffset x offset to be moved.
     * @param yOffset y offset to be moved.
     */
    public void move(int xOffset, int yOffset) {
        this.coordinate.move(xOffset, yOffset);
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
        final Coordinate dest = this.coordinate.copy();
        dest.move(xOffset, yOffset);
        return peek(dest);
    }
}
