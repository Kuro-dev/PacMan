package logic;

import game.logic.actor.Actor;
import game.logic.area.map.MapReader;
import game.logic.area.map.PlayField;
import game.logic.area.position.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActorTest {

    private static PlayField getPlayNewField() {
        return new MapReader(ActorTest.class.getResourceAsStream("/map/actorTestMap.field")).read();
    }

    @Test
    public void actorCanMoveSafely() {
        final PlayField playField = getPlayNewField();
        final Actor actor = playField.getPacMan();
        String onFail = "Could not move when it should've worked";
        assertTrue(actor.peek(-1, 0), onFail);
        assertTrue(actor.peek(0, -1), onFail);
        assertTrue(actor.peek(-1, -1));
        //Moving the character by one position to the left to see
        // if peaking right will show the now empty spot
        actor.moveSafely(Direction.EAST);
        assertTrue(actor.peek(1, 0), onFail);
    }

    @Test
    public void actorCannotMoveSafely() {
        final PlayField playField = getPlayNewField();
        final String onFail = "Could move when it shouldn't have worked";
        final Actor actor = playField.getPacMan();
        assertFalse(actor.peek(1, 0), onFail);
        assertFalse(actor.peek(0, 1), onFail);
        assertFalse(actor.peek(2, 1), onFail);
    }
}
