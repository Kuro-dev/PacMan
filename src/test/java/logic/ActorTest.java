package logic;

import game.logic.actor.Actor;
import game.logic.area.map.MapReader;
import game.logic.area.map.PlayField;
import game.logic.area.position.Direction;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActorTest {
    private static PlayField getPlayNewField() {
        return new MapReader(ActorTest.class.getResourceAsStream("/map/actorTestMap.field")).read();
    }

    @Test
    public void actorPeekTest() {
        final PlayField playField = getPlayNewField();
        final Actor actor = playField.getPacMan();
        final String onFail = "Could not move when it should've worked";
        assertTrue(actor.peek(-1, 0), onFail);
        assertTrue(actor.peek(0, -1), onFail);
        assertTrue(actor.peek(-1, -1));
    }

    @Test
    public void testIfPeekWillChangeResultDependingOnPosition() {
        final PlayField playField = getPlayNewField();
        final Actor actor = playField.getPacMan();
        final String onFail = "Could not move when it should've worked";
        assertFalse(actor.peek(1, 0), "Peek returned true when it was directed at a wall");
        actor.moveSafely(Direction.EAST);
        assertTrue(actor.peek(1, 0), onFail);
    }

    @Test
    public void actorCannotPeekTest() {
        final PlayField playField = getPlayNewField();
        final String onFail = "Could move when it shouldn't have worked";
        final Actor actor = playField.getPacMan();
        assertFalse(actor.peek(1, 0), onFail);
        assertFalse(actor.peek(0, 1), onFail);
        assertFalse(actor.peek(2, 1), onFail);
    }
}
