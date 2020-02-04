package logic;

import game.logic.actor.Actor;
import game.logic.area.field.Tile;
import game.logic.area.map.MapReader;
import game.logic.area.map.PlayField;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActorTest {

    private static PlayField getPlayNewField() {
        return new MapReader(ActorTest.class.getResourceAsStream("/map/actorTestMap.field")).read();
    }

    @Test
    public void actorCanMoveSafely() {
        final PlayField playField = getPlayNewField();
        final List<Tile> tiles = playField.getTiles();
        final Actor actor = playField.getPacMan();
        String onFail = "Could not move when it should've worked";
        assertTrue(actor.moveSafely(-1, 0, tiles), onFail);
        assertTrue(actor.moveSafely(0, -1, tiles), onFail);
        assertTrue(actor.moveSafely(1, 0, tiles), onFail);
        assertTrue(actor.moveSafely(0, 1, tiles), onFail);
        assertTrue(actor.moveSafely(-1, -1, tiles));
    }

    @Test
    public void actorCannotMoveSafely() {
        final PlayField playField = getPlayNewField();
        final String onFail = "Could move when it shouldn't have worked";
        final List<Tile> tiles = playField.getTiles();
        final Actor actor = playField.getPacMan();
        assertFalse(actor.moveSafely(1, 0, tiles), onFail);
        assertFalse(actor.moveSafely(0, 1, tiles), onFail);
        assertFalse(actor.moveSafely(2, 1, tiles));
    }
}
