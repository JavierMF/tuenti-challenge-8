package org.javiermf.tuenti8.challenge5.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class Sequence {

    List<AdnSegment> segments = new ArrayList<>();

    public Sequence(AdnSegment firstSegment) {
        addSegment(firstSegment);
    }

    public void addSegment(AdnSegment adnSegment) {
        segments.add(adnSegment);
    }

    public List<Integer> getIndexes() {
        return segments.stream()
                .map(AdnSegment::getPos)
                .collect(Collectors.toList());
    }

    public String adnString() {
        return segments.stream()
                .map(AdnSegment::getContents)
                .collect(Collectors.joining());
    }

    public Sequence duplicate() {
        Sequence dupSequence = new Sequence();

        segments.stream()
                .forEach(segment -> dupSequence.addSegment(segment));

        return dupSequence;
    }

    @Override
    public String toString() {
        return adnString() + " (" + getIndexes().stream()
                .map(Object::toString)
                .collect(Collectors.joining(",")) + ")";
    }
}
