package game.logic.area.position;

import java.util.Objects;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private Coordinate(Coordinate coordinate) {
        this(coordinate.x, coordinate.y);
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int xOffset, int yOffset) {
        set(x + xOffset, y + yOffset);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Creates a clones instance of the given object. They will be equal in Hashcode and the {@link #equals(Object)}
     * method will return true. However they will not be the same coordinate,
     * therefore if one gets its values changed the other remains untouched
     *
     * @return A new coordinate instance containing the same values as the cloned one.
     */
    @Override
    public Coordinate clone() {
        return new Coordinate(this);
    }
}