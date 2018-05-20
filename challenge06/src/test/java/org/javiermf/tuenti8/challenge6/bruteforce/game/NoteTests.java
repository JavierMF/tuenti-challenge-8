package org.javiermf.tuenti8.challenge6.bruteforce.game;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NoteTests {

    @Test
    public void deberiaCalcularInicio() {
        Note note = new Note(4, 2, 1, 1);
        assertThat(note.getHitStart(), is(4));

        Note otherNote = new Note(4, 2, 2, 2);
        assertThat(otherNote.getHitStart(), is(2));
    }

    @Test
    public void deberiaCalcularFinal() {
        Note note = new Note(4, 2, 1, 1);
        assertThat(note.getHitEnd(), is(6));

        Note otherNote = new Note(4, 2, 2, 2);
        assertThat(otherNote.getHitEnd(), is(3));
    }
}
