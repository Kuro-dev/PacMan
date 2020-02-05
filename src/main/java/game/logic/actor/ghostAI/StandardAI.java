package game.logic.actor.ghostAI;

import game.logic.actor.Ghost;
import game.logic.actor.Pac;
import game.logic.area.position.Direction;

public class StandardAI implements GhostAI {
    public static final StandardAI INSTANCE = new StandardAI();

    @Override
    public Direction getTargetDirection(Ghost ghost, Pac pac) {
        return null;
    }
}
