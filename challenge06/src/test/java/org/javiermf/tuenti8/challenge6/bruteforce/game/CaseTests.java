package org.javiermf.tuenti8.challenge6.bruteforce.game;

import org.javiermf.tuenti8.challenge6.bruteforce.Case;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CaseTests {

    @Test
    public void deberiaResolverCaso1() {
        Case aCase = new Case();

        aCase.addNote(4, 2, 1, 1);
        aCase.addNote(4, 2, 2, 2);

        assertThat(aCase.maxScore(), is(3));
    }

    @Test
    public void deberiaResolverCaso2() {
        Case aCase = new Case();

        aCase.addNote(2, 2, 2, 1);
        aCase.addNote(1, 1, 1, 1);
        assertThat(aCase.maxScore(), is(2));
    }

    @Test
    public void deberiaResolverCaso3() {
        Case aCase = new Case();

        aCase.addNote(2, 1, 1, 1);
        aCase.addNote(3, 1, 1, 2);
        aCase.addNote(2, 2, 1, 1);

        assertThat(aCase.maxScore(), is(2));
    }

    @Test
    public void deberiaResolverCaso4() {
        Case aCase = new Case();

        aCase.addNote(18, 2, 2, 5);
        aCase.addNote(1, 2, 1, 1);
        aCase.addNote(16, 10, 2, 3);
        aCase.addNote(8, 10, 2, 4);
        aCase.addNote(27, 6, 3, 5);

        assertThat(aCase.maxScore(), is(6));
    }

    @Test
    public void deberiaResolverCasoTest10() {

        Case aCase = new Case();

        aCase.addNote("18 12 3 2");
        aCase.addNote("4 4 2 5");
        aCase.addNote("10 25 5 4");
        aCase.addNote("40 25 5 5");
        aCase.addNote("2 1 1 1");
        aCase.addNote("25 25 5 3");
        aCase.addNote("30 20 5 4");
        aCase.addNote("5 4 1 3");
        aCase.addNote("20 12 4 1");

        assertThat(aCase.maxScore(), is(11));

    }

    @Test
    public void deberiaResolverCasoTest25() {
        Case aCase = new Case();

        aCase.addNote("24 3 3 1");
        aCase.addNote("15 6 3 3");
        aCase.addNote("24 12 4 5");
        aCase.addNote("45 20 5 3");
        aCase.addNote("10 25 5 2");

        assertThat(aCase.maxScore(), is(6));
    }
}
