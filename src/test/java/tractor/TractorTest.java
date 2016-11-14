package tractor;

import org.junit.Test;
import tractor.items.Field;
import tractor.items.Point;

import static org.junit.Assert.*;
import static tractor.items.Orientation.*;

public class TractorTest {
    @Test
    public void testMoves() throws Exception {
        Tractor tractor = new Tractor();
        tractor.move("R");
        assertEquals(0, tractor.getPositionX());
        assertEquals(0, tractor.getPositionY());
        assertEquals(NORTH, tractor.getOrientation());
    }

    @Test
    public void testMoveForwards() {
        Tractor tractor = new Tractor();
        tractor.move("F");
        assertEquals(0, tractor.getPositionX());
        assertEquals(1, tractor.getPositionY());
        tractor.move("F");
        assertEquals(0, tractor.getPositionX());
        assertEquals(2, tractor.getPositionY());

    }

    @Test
    public void testTurnClockwise() throws Exception {
        Tractor tractor = new Tractor();
        tractor.move("T");
        assertEquals(EAST, tractor.getOrientation());
        tractor.move("T");
        assertEquals(SOUTH, tractor.getOrientation());
        tractor.move("T");
        assertEquals(WEST, tractor.getOrientation());
        tractor.move("T");
        assertEquals(NORTH, tractor.getOrientation());
    }

    @Test
    public void testMoveAndTurnTractor() {
        Tractor tractor = new Tractor();
        tractor.move("F");
        tractor.move("T");
        tractor.move("F");
        tractor.move("F");
        tractor.move("T");
        tractor.move("F");
        assertEquals(2, tractor.getPositionX());
        assertEquals(0, tractor.getPositionY());
        assertEquals(SOUTH, tractor.getOrientation());
    }

    @Test(expected = TractorInDitchException.class)
    public void testOutOfBounds() {
        Tractor tractor = new Tractor(new Point(0, 0), new Field(new Point(2, 2)), NORTH);
        tractor.move("F");
        tractor.move("F");
        tractor.move("F");
    }

}