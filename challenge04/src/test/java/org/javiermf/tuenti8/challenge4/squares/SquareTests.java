package org.javiermf.tuenti8.challenge4.squares;

import org.javiermf.tuenti8.challenge4.Position;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SquareTests {

    @Test
    public void deberiaCacularBienCoordenadasCortas() {
        Square square = new Square(new Position(1, 1), SquareContents.KNIGHT);

        Set<Position> nextPositions = square.getJumpingPositions();

        assertEquals(8, nextPositions.size());
        assertTrue(nextPositions.contains(new Position(-1, 0)));
        assertTrue(nextPositions.contains(new Position(-1, 2)));
        assertTrue(nextPositions.contains(new Position(3, 0)));
        assertTrue(nextPositions.contains(new Position(3, 2)));

        assertTrue(nextPositions.contains(new Position(0, -1)));
        assertTrue(nextPositions.contains(new Position(2, -1)));
        assertTrue(nextPositions.contains(new Position(0, 3)));
        assertTrue(nextPositions.contains(new Position(2, 3)));
    }
}
