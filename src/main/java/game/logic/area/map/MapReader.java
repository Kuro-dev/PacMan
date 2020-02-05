package game.logic.area.map;

import game.logic.actor.Ghost;
import game.logic.actor.Pac;
import game.logic.area.field.Tile;
import game.logic.area.position.Coordinate;
import game.logic.exception.InvalidMapException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MapReader {
    private final InputStream mapContent;

    public MapReader(InputStream mapContent) {

        this.mapContent = mapContent;
    }

    public PlayField read() {
        final List<String> lines = getLines();
        final ArrayList<Tile> tiles = new ArrayList<>();
        final ArrayList<Ghost> ghosts = new ArrayList<>();
        Pac pacMan = null;
        int width = 0;
        final int height = lines.size();
        for (int y = 0; y < height; y++) {
            final char[] line = lines.get(y).toCharArray();
            width = line.length;
            for (int x = 0; x < width; x++) {
                final Coordinate location = new Coordinate(x, y);
                switch (FieldIdentifier.valueOf(line[x])) {
                    case PAC:
                        pacMan = new Pac(location, tiles);
                        tiles.add(new Tile(location.copy(), false));
                        break;
                    case GHOST:
                        ghosts.add(new Ghost(location, tiles));
                        tiles.add(new Tile(location.copy(), false));
                        break;
                    case WALL:
                        tiles.add(new Tile(location, true));
                        break;
                    case AIR:
                        tiles.add(new Tile(location, false));
                        break;
                }
            }
        }
        if (pacMan == null) {
            throw new InvalidMapException("pacMan not found in map File");
        }
        for (Ghost ghost : ghosts) {
            ghost.setPac(pacMan);
        }
        return new PlayField(tiles, pacMan, ghosts);
    }

    private List<String> getLines() {
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(mapContent));
            final ArrayList<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
