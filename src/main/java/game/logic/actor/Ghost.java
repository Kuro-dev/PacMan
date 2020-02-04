package game.logic.actor;

import game.logic.area.field.Tile;
import game.logic.area.position.Coordinate;

import java.util.ArrayList;

public class Ghost extends Actor implements Runnable {

    public Ghost(Coordinate coordinate, ArrayList<Tile> tiles) {
        super(coordinate, tiles);
    }

    @Override
    public void run() {

    }
}
