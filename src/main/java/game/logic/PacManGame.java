package game.logic;

import game.logic.actor.Ghost;
import game.logic.actor.Pac;
import game.logic.area.map.MapReader;
import game.logic.area.map.PlayField;
import game.logic.exception.InvalidMapException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PacManGame {
    private final int lives;
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private PlayField field;

    public PacManGame(int lives) {
        this.lives = lives;
    }

    public void startNew(File file) {
        try {
            final MapReader reader = new MapReader(new FileInputStream(file));
            field = reader.read();
            for (Ghost ghost : field.getGhosts()) {
                executor.execute(ghost);
            }
        } catch (FileNotFoundException e) {
            throw new InvalidMapException(e.getLocalizedMessage());
        }
    }

    public Pac getPacMan() {
        return field.getPacMan();
    }

    public Ghost[] getGhosts() {
        return field.getGhosts();
    }

    public PlayField getField() {
        return field;
    }

    public void shutdown() {
        executor.shutdown();
    }
}
