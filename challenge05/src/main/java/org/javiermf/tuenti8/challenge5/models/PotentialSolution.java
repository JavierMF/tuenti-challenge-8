package org.javiermf.tuenti8.challenge5.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class PotentialSolution {
    private final List<AdnSegment> segments;
    private Sequence shortSequence;
    private Sequence largeSequence;

    public PotentialSolution(AdnSegment segment1, AdnSegment segment2, List<AdnSegment> segments) {
        this(new Sequence(segment1), new Sequence(segment2), segments);
    }

    public PotentialSolution(Sequence sequence1, Sequence sequence2, List<AdnSegment> segments) {
        this.shortSequence = (sequence1.adnString().length() < sequence2.adnString().length()) ? sequence1 : sequence2;
        this.largeSequence = (shortSequence == sequence1) ? sequence2 : sequence1;
        this.segments = segments;
        //System.out.println(this);
    }

    public Optional<String> evaluate() {
        if (isReady()) {
            return Optional.of(buildOrderedSequencesIndexes());
        }

        for (PotentialSolution potentialSolution : nextSolutions()) {
            Optional<String> solutionResult = potentialSolution.evaluate();
            if (solutionResult.isPresent()) {
                return solutionResult;
            }
        }

        return Optional.empty();
    }

    private String buildOrderedSequencesIndexes() {
        return sequencesIndexes().stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }

    private List<Integer> sequencesIndexes() {
        List<Integer> indexes = new ArrayList<>();
        indexes.addAll(shortSequence.getIndexes());
        indexes.addAll(largeSequence.getIndexes());
        return indexes;
    }

    private Set<PotentialSolution> nextSolutions() {

        String difference = findDifference(shortSequence.adnString(), largeSequence.adnString());

        List<Integer> usedIndexes = sequencesIndexes();
        return segments.stream()
                .filter(segment -> !usedIndexes.contains(segment.pos))
                .filter(segment -> segment.matchesStart(difference))
                .map(segment -> buildNewPotentialSolution(segment))
                .collect(Collectors.toSet());
    }

    protected static String findDifference(String shortestString, String largestString) {
        return largestString.substring(shortestString.length());
    }

    private PotentialSolution buildNewPotentialSolution(AdnSegment segment) {
        Sequence shortSeq = shortSequence.duplicate();
        shortSeq.addSegment(segment);
        return new PotentialSolution(shortSeq, largeSequence.duplicate(), segments);
    }


    private boolean isReady() {
        return shortSequence.adnString().equals(largeSequence.adnString());
    }

    @Override
    public String toString() {
        return String.format("[%s] [%s]", shortSequence, largeSequence);
    }
}
