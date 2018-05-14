package org.javiermf.tuenti8.challenge3.scales;

import org.javiermf.tuenti8.challenge3.Note;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ScaleTests {

    @Test
    public void deberiaPertenecerALaEscala() {
        Set<Note> scaleNotes = Stream.of(Note.values()).collect(Collectors.toSet());
        Scale scale = new Scale(Note.C, ScaleMode.MAJOR, scaleNotes);

        Set<Note> melodyNotes = Stream.of(Note.C, Note.D).collect(Collectors.toSet());
        assertTrue(scale.containsAllNotes(melodyNotes));
    }

    @Test
    public void noDeberiaPertenecerALaEscala() {
        Set<Note> scaleNotes = Stream.of(Note.E, Note.F).collect(Collectors.toSet());
        Scale scale = new Scale(Note.C, ScaleMode.MAJOR, scaleNotes);

        Set<Note> melodyNotes = Stream.of(Note.C, Note.D).collect(Collectors.toSet());
        assertFalse(scale.containsAllNotes(melodyNotes));
    }
}
