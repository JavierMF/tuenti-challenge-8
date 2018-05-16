package org.javiermf.tuenti8.challenge4;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class CaseTests {

    @Test
    public void deberiaResolverCaso1() {
        Case aCase = new Case(new Board(4, 5));

        aCase.addRow(0, "P#.S#");
        aCase.addRow(1, ".#...");
        aCase.addRow(2, "#.#..");
        aCase.addRow(3, ".D..#");

        assertEquals(Optional.of(3), aCase.fromKnightToPrincess());
        assertEquals(Optional.of(2), aCase.fromPrincessToDestination());

        assertEquals("5", aCase.minSteps());

    }

    @Test
    public void deberiaResolverCaso2() {
        Case aCase = new Case(new Board(4, 5));

        aCase.addRow(0, ".#.D#");
        aCase.addRow(1, ".#...");
        aCase.addRow(2, "#S#.#");
        aCase.addRow(3, ".P..#");


        assertEquals("IMPOSSIBLE", aCase.minSteps());

    }

    @Test
    public void deberiaResolverCaso3() {
        Case aCase = new Case(new Board(6, 6));

        aCase.addRow(0, "S#....");
        aCase.addRow(1, "##*..D");
        aCase.addRow(2, "......");
        aCase.addRow(3, "######");
        aCase.addRow(4, "......");
        aCase.addRow(5, "P.....");


        assertEquals("5", aCase.minSteps());

    }
}
