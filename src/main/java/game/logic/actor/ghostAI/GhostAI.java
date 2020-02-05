package game.logic.actor.ghostAI;

import game.logic.actor.Ghost;
import game.logic.actor.Pac;
import game.logic.area.position.Direction;

public interface GhostAI {
    Direction getTargetDirection(Ghost ghost, Pac pac);
}
