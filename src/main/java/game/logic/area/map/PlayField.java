package game.logic.area.map;

import game.logic.actor.Ghost;
import game.logic.actor.Pac;
import game.logic.area.field.Tile;

import java.util.List;

public class PlayField {
    private final Tile[] tiles;
    private final Pac pacMan;
    private Ghost[] ghosts;

    protected PlayField(List<Tile> tiles, Pac pacMan, List<Ghost> ghosts) {

        this.tiles = tiles.toArray(new Tile[0]);
        this.pacMan = pacMan;
        this.ghosts = ghosts.toArray(new Ghost[0]);
    }

    public Tile[] getTiles() {
        return tiles;
    }

    public Pac getPacMan() {
        return pacMan;
    }

    public Ghost[] getGhosts() {
        return ghosts;
    }
}
