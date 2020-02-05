package logic;

import game.logic.area.field.Tile;
import game.logic.area.map.MapReader;
import game.logic.area.map.PlayField;
import game.logic.area.position.Coordinate;
import game.logic.exception.InvalidMapException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class MapCreation {
    @Test
    public void buildMapFromFile() {
        final InputStream stream = getClass().getResourceAsStream("/map/defaultMap.field");
        final MapReader map = new MapReader(stream);
        final PlayField field = map.read();
    }

    @Test
    public void readingMapWithoutPacTest() {
        final InputStream stream = getClass().getResourceAsStream("/map/noPacMap.field");
        final MapReader map = new MapReader(stream);
        Assertions.assertThrows(InvalidMapException.class, map::read);
    }

    @Test
    public void coordinatesEqualTest() {
        assertEquals(new Coordinate(5, 7), new Coordinate(5, 7));
        assertNotEquals(new Coordinate(3, 4), new Coordinate(1, 2));
        Coordinate coordinate = new Coordinate(10, 10);
        assertEquals(coordinate, coordinate);
    }

    @Test
    public void tileHasFoodOnlyOnceTest() {
        Tile tile = new Tile(new Coordinate(5, 5), true);
        assertFalse(tile.getFood());
        Tile tile2 = new Tile(new Coordinate(3, 3), false);
        assertTrue(tile2.getFood());
        assertFalse(tile2.getFood());
        tile2.reset();
        assertTrue(tile2.getFood());
    }
}
