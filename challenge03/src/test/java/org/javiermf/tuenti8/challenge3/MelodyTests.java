package org.javiermf.tuenti8.challenge3;

import org.javiermf.tuenti8.challenge3.scales.Scale;
import org.javiermf.tuenti8.challenge3.scales.ScaleFactory;
import org.junit.Test;

import java.util.Set;

import static org.javiermf.tuenti8.challenge3.Note.*;
import static org.javiermf.tuenti8.challenge3.scales.ScaleMode.MAJOR;
import static org.javiermf.tuenti8.challenge3.scales.ScaleMode.MINOR;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MelodyTests {

    @Test
    public void deberiaIdentificarLasNotas() {
        Melody melody = new Melody("C C G G A A G", new ScaleFactory());
        Set<Note> notes = melody.getDifferentNotes();

        assertEquals(3, notes.size());
        assertTrue(notes.contains(Note.C));
        assertTrue(notes.contains(G));
        assertTrue(notes.contains(Note.C));
    }

    @Test
    public void deberiaIdentificarEstasNotasTambien() {
        Melody melody = new Melody("E D# E D# E B D C A", new ScaleFactory());
        Set<Note> notes = melody.getDifferentNotes();

        assertEquals(6, notes.size());
        assertTrue(notes.contains(E));
        assertTrue(notes.contains(Note.D_));
        assertTrue(notes.contains(Note.B));
        assertTrue(notes.contains(Note.C));
        assertTrue(notes.contains(Note.A));
    }

    @Test
    public void deberiaIdentificarLasEscalasCaso3() {
        ScaleFactory scaleFactory = new ScaleFactory();
        Melody melody = new Melody("E D# E F# G# G# F# G# A A G# C# B A G# D# E F# G# G# F# E", scaleFactory);

        Set<Scale> scales = melody.fittingScales();

        assertEquals(2, scales.size());

        Scale eMaj = scaleFactory.getScale(E, MAJOR);
        assertTrue(scales.contains(eMaj));

        Scale cSharpMinor = scaleFactory.getScale(C_, MINOR);
        assertTrue(scales.contains(cSharpMinor));
    }

    @Test
    public void deberiaIdentificarLasEscalasCaso2() {
        ScaleFactory scaleFactory = new ScaleFactory();
        Melody melody = new Melody("E D# E D# E B D C A", scaleFactory);

        Set<Scale> scales = melody.fittingScales();

        assertEquals(0, scales.size());
    }

    @Test
    public void deberiaIdentificarLasEscalasCaso1() {
        ScaleFactory scaleFactory = new ScaleFactory();
        Melody melody = new Melody("C C G G A A G", scaleFactory);

        Set<Scale> scales = melody.fittingScales();

        assertEquals(8, scales.size());

        Scale aSharpMaj = scaleFactory.getScale(A_, MAJOR);
        assertTrue(scales.contains(aSharpMaj));

        Scale gMinor = scaleFactory.getScale(G, MINOR);
        assertTrue(scales.contains(gMinor));
    }

    @Test
    public void deberiaIdentificarLasEscalasCaso4() {
        ScaleFactory scaleFactory = new ScaleFactory();
        Melody melody = new Melody("Fb", scaleFactory);

        Set<Scale> scales = melody.fittingScales();

        assertEquals(14, scales.size());
    }

    @Test
    public void deberiaIdentificarLasEscalasCaso5() {
        ScaleFactory scaleFactory = new ScaleFactory();
        Melody melody = new Melody("", scaleFactory);

        Set<Scale> scales = melody.fittingScales();

        assertEquals(24, scales.size());
    }
}
