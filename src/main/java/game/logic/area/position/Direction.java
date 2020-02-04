package game.logic.area.position;

public enum Direction {
    NORTH(0, -1),
    EAST(-1, 0),
    SOUTH(0, 1),
    WEST(1, 0),
    ;

    private final int xOffset;
    private final int yOffset;

    Direction(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public int getX() {
        return xOffset;
    }

    public int getY() {
        return yOffset;
    }
}
