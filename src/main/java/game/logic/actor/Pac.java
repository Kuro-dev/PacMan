package game.logic.actor;

import game.logic.area.field.Tile;
import game.logic.area.position.Coordinate;

import java.util.ArrayList;

public class Pac extends Actor{

    public Pac(Coordinate coordinate, ArrayList<Tile> tiles) {
        super(coordinate,tiles);
    }
}
