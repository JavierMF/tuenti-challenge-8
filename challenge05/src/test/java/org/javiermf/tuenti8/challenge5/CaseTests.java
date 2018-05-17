package org.javiermf.tuenti8.challenge5;

import org.javiermf.tuenti8.challenge5.models.Pair;
import org.junit.Test;

import java.util.Optional;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CaseTests {

    @Test
    public void case1() {
        String caseString = "aacc GgTTC aaccG gTTC aaaa cccc gttc";

        Case aCase = new Case(caseString);

        Set<Pair> pairsThatStartTheSame = aCase.findPairsThatStartTheSame();
        assertThat(pairsThatStartTheSame.size(), is(1));

        Optional<Pair> first = pairsThatStartTheSame.stream()
                .findFirst();
        assertThat(first.isPresent(), is(true));
        Pair pair = first.get();
        assertThat(pair.getSegment1().getPos(), is(1));
        assertThat(pair.getSegment2().getPos(), is(3));

        assertThat(aCase.solve(), is("1,2,3,4"));
    }

    @Test
    public void case2() {
        String caseString = "TATaCaACcCG aAgGacctcTtGgt TAttaCAtaTtA CgG TAttaCAtaTtAC CTATaCaACcCGcGg CCcCTaGcATaC cTgTGGAGAg cGgCgG";

        Case aCase = new Case(caseString);
        assertThat(aCase.solve(), is("1,3,4,5,6,9"));
    }

    @Test
    public void caseConsole() {
        //String caseString = "ATCcGGTaCgaC cAAGaGATattACc CctcTTtttaC tcTTtttaCtt cAAGaGATattA ttgCccT TTCTcAgcGGgtt gCccT gGccctTgcAcc";
        String caseString = "CAgccCGAtATgG aATtAtCttGggCT GcggAaCtTtaC CAgccCGAtATg Cta cggAaCtTtaCtgC CTggtCAgcgt tgCCta";

        Case aCase = new Case(caseString);
        System.out.println(aCase.solve());
    }
}
