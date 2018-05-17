package org.javiermf.tuenti8.challenge5.models;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PotentialSolutionTests {

    @Test
    public void deberiaEncontrarLaDiferencia() {
        String string1 = "TAttaCAtaTtA";
        String string2 = "TAttaCAtaTtAC";

        String difference = PotentialSolution.findDifference(string1, string2);
        assertThat(difference, is("C"));

    }
}
