package game.logic.actor;

import game.logic.area.field.Tile;
import game.logic.area.position.Coordinate;
import game.logic.area.position.Direction;

import java.util.List;

public abstract class Actor {
    protected final Coordinate coordinate;

    public Actor(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Moves the actor to the given position, however checks if the position is free beforehand.
     *
     * @param xOffset    The x offset of which the actor is to be moved
     * @param yOffset    The y offset of which the actor is to be moved
     * @param fieldTiles The tiles of the playField
     * @return true if the character has been successfully moved
     */
    public boolean moveSafely(int xOffset, int yOffset, List<Tile> fieldTiles) {
        final Coordinate dest = this.coordinate.clone();
        dest.move(xOffset, yOffset);
        boolean peek = peek(dest, fieldTiles);
        if (peek) {
            this.coordinate.move(xOffset, yOffset);
        }
        return peek;
    }

    public boolean moveSafely(Direction direction, List<Tile> fieldTiles) {
        return moveSafely(direction.getX(), direction.getY(), fieldTiles);
    }

    /**
     * Peaks at the given coordinates to find out what is there.
     *
     * @param coordinate The coordinate to peek at.
     * @param tiles      The list of tiles in the playfield
     * @return true if the given coordinate is a free space to walk on.
     */
    public boolean peek(Coordinate dest, List<Tile> tiles) {
        for (Tile tile : tiles) {
            final boolean equal = tile.getCoordinate().equals(dest);
            if (equal) {
                return !tile.isWall();
            }
        }
        return false;
    }
}
