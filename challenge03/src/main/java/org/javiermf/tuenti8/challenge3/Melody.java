package org.javiermf.tuenti8.challenge3;

import org.javiermf.tuenti8.challenge3.scales.Scale;
import org.javiermf.tuenti8.challenge3.scales.ScaleFactory;

import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Collections.emptySet;

public class Melody {
    private final ScaleFactory scalesFactory;
    Set<Note> notes;

    public Melody(String notesLine, ScaleFactory scalesFactory) {
        this.scalesFactory = scalesFactory;

        if (notesLine.isEmpty()) {
            notes = emptySet();
        } else {
            String[] stringNotes = notesLine.split(" ");

            notes = asList(stringNotes).stream()
                    .map(note -> Note.forName(note))
                    .collect(Collectors.toSet());
        }
    }

    public Set<Scale> fittingScales() {
        if (notes.isEmpty()) {
            return scalesFactory.getAllScales();
        }

        return scalesFactory.getAllScales().stream()
                .filter(scale -> scale.containsAllNotes(notes))
                .collect(Collectors.toSet());
    }

    public Set<Note> getDifferentNotes() {
        return notes;
    }
}
