package org.javiermf.tuenti8.challenge4;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PositionTests {

    @Test
    public void deberiaEstarEnLimite() {
        Position position = new Position(3, 3);

        assertTrue(position.isInLimits(4, 5));
    }
}
