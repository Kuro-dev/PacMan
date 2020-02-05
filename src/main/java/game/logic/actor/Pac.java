package game.logic.actor;

import game.logic.area.field.Tile;
import game.logic.area.position.Coordinate;

import java.util.ArrayList;

public class Pac extends Actor {
    private final Coordinate initialCoordinate;

    public Pac(Coordinate coordinate, ArrayList<Tile> tiles) {
        super(coordinate, tiles);
        initialCoordinate = coordinate.copy();
    }

    /**
     * Resets the Pac to its original spawn position
     */
    public void reset() {
        this.coordinate.set(initialCoordinate);
    }
}
