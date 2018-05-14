package org.javiermf.tuenti8.challenge3.scales;

import org.javiermf.tuenti8.challenge3.Note;
import org.junit.Test;

import java.util.Set;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScaleFactoryTests {

    @Test
    public void deberiaGenerarLaEscalaCMay() {
        ScaleFactory scaleFactory = new ScaleFactory();

        Set<Note> cMajScaleNotes = scaleFactory.buildScaleNotes(Note.C, ScaleMode.MAJOR);

        assertEquals(7, cMajScaleNotes.size());
        assertTrue(cMajScaleNotes.contains(Note.C));
        assertTrue(cMajScaleNotes.contains(Note.D));
        assertTrue(cMajScaleNotes.contains(Note.E));
        assertTrue(cMajScaleNotes.contains(Note.F));
        assertTrue(cMajScaleNotes.contains(Note.G));
        assertTrue(cMajScaleNotes.contains(Note.A));
        assertTrue(cMajScaleNotes.contains(Note.B));

        assertFalse(cMajScaleNotes.contains(Note.C_));
        assertFalse(cMajScaleNotes.contains(Note.D_));
    }

    @Test
    public void deberiaGenerarLaEscalaGMin() {
        ScaleFactory scaleFactory = new ScaleFactory();

        Set<Note> cMajScaleNotes = scaleFactory.buildScaleNotes(Note.G, ScaleMode.MINOR);

        assertEquals(7, cMajScaleNotes.size());
        assertTrue(cMajScaleNotes.contains(Note.G));
        assertTrue(cMajScaleNotes.contains(Note.A));
        assertTrue(cMajScaleNotes.contains(Note.A_));
        assertTrue(cMajScaleNotes.contains(Note.C));
        assertTrue(cMajScaleNotes.contains(Note.D));
        assertTrue(cMajScaleNotes.contains(Note.D_));
        assertTrue(cMajScaleNotes.contains(Note.F));

        assertFalse(cMajScaleNotes.contains(Note.B));
        assertFalse(cMajScaleNotes.contains(Note.E));
    }

    @Test
    public void deberiaGenerarLaEscalaAMin() {
        ScaleFactory scaleFactory = new ScaleFactory();

        Set<Note> cMajScaleNotes = scaleFactory.buildScaleNotes(Note.A, ScaleMode.MINOR);

        assertEquals(7, cMajScaleNotes.size());
        assertTrue(cMajScaleNotes.contains(Note.C));
        assertTrue(cMajScaleNotes.contains(Note.D));
        assertTrue(cMajScaleNotes.contains(Note.E));
        assertTrue(cMajScaleNotes.contains(Note.F));
        assertTrue(cMajScaleNotes.contains(Note.G));
        assertTrue(cMajScaleNotes.contains(Note.A));
        assertTrue(cMajScaleNotes.contains(Note.B));

        assertFalse(cMajScaleNotes.contains(Note.C_));
        assertFalse(cMajScaleNotes.contains(Note.D_));
    }
}
