package org.javiermf.tuenti8.challenge5;

import org.javiermf.tuenti8.challenge5.models.AdnSegment;
import org.javiermf.tuenti8.challenge5.models.Pair;
import org.javiermf.tuenti8.challenge5.models.PotentialSolution;

import java.util.*;

public class Case {

    List<AdnSegment> segments = new ArrayList<>();

    public Case(String caseString) {
        int index = 1;
        for (String adnString : caseString.split(" ")) {
            AdnSegment adnSegment = new AdnSegment(index++, adnString);
            segments.add(adnSegment);
        }
    }

    public String solve() {
        Set<Pair> startingPairs = findPairsThatStartTheSame();

        for (Pair startingPair : startingPairs) {
            PotentialSolution potentialSolution = new PotentialSolution(startingPair.getSegment1(), startingPair.getSegment2(), segments);

            Optional<String> solutionResult = potentialSolution.evaluate();
            if (solutionResult.isPresent()) {
                return solutionResult.get();
            }
        }

        return "IMPOSSIBLE";
    }

    protected Set<Pair> findPairsThatStartTheSame() {
        Set<Pair> startingPairs = new HashSet<>();
        for (AdnSegment segment : segments) {
            Optional<AdnSegment> match = segments.stream()
                    .filter(s -> s.startsLike(segment))
                    .findFirst();
            if (match.isPresent()) {
                startingPairs.add(new Pair(segment, match.get()));
            }
        }
        return startingPairs;
    }
}
