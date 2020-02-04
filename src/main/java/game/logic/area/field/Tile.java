package game.logic.area.field;

import game.logic.area.position.Coordinate;

public class Tile {
    private final Coordinate coordinate;
    private final boolean isWall;
    private boolean hasFood;

    public Tile(Coordinate coordinate, boolean isWall) {
        this.coordinate = coordinate;
        hasFood = !isWall;
        this.isWall = isWall;
    }

    /**
     * @return True if the tile has food, but only once per lifetime.
     */
    public boolean getFood() {
        if (hasFood) {
            hasFood = false;
            return true;
        }
        return false;
    }

    public void reset() {
        hasFood = !isWall;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public boolean isWall() {
        return isWall;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "coordinate=" + coordinate +
                '}';
    }
}
