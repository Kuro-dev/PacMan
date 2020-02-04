package game.logic.area.map;

import game.logic.actor.Ghost;
import game.logic.actor.Pac;
import game.logic.area.field.Tile;

import java.util.List;

public class PlayField {
    private final List<Tile> tiles;
    private final Pac pacMan;
    private final List<Ghost> ghosts;

    public PlayField(List<Tile> tiles, Pac pacMan, List<Ghost> ghosts) {

        this.tiles = tiles;
        this.pacMan = pacMan;
        this.ghosts = ghosts;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public Pac getPacMan() {
        return pacMan;
    }

    public List<Ghost> getGhosts() {
        return ghosts;
    }
}
