package game.logic.actor;

import game.logic.actor.ghostAI.GhostAI;
import game.logic.actor.ghostAI.StandardAI;
import game.logic.area.field.Tile;
import game.logic.area.position.Coordinate;

import java.util.ArrayList;

public class Ghost extends Actor implements Runnable {

    private GhostAI ai;
    private Pac pacMan;

    public Ghost(Coordinate coordinate, ArrayList<Tile> tiles) {
        this(coordinate, tiles, StandardAI.INSTANCE);
    }

    public Ghost(Coordinate coordinate, ArrayList<Tile> tiles, GhostAI ai) {
        super(coordinate, tiles);
        this.ai = ai;
    }

    @Override
    public void run() {
        assert pacMan != null;

    }

    public void setAi(GhostAI ai) {
        this.ai = ai;
    }

    public void setPac(Pac pacMan) {

        this.pacMan = pacMan;
    }

    private boolean pacManDetected() {
        return this.coordinate.equals(pacMan.coordinate);
    }
}
