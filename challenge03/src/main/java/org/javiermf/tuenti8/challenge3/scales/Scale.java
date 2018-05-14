package org.javiermf.tuenti8.challenge3.scales;

import org.javiermf.tuenti8.challenge3.Note;

import java.util.Set;

public class Scale {

    private final Note tonic;
    private final ScaleMode mode;
    private final Set<Note> notesInScale;
    private final int sortingWeight;

    public Scale(Note tonic, ScaleMode mode, Set<Note> notesInScale) {
        this.tonic = tonic;
        this.mode = mode;
        this.notesInScale = notesInScale;
        this.sortingWeight = mode.weight() + tonic.weight();
    }

    public boolean containsAllNotes(Set<Note> notes) {
        return notes.stream()
                .allMatch(note -> notesInScale.contains(note));
    }

    public boolean is(Note note, ScaleMode mode) {
        return (note == tonic) && (this.mode == mode);
    }

    @Override
    public String toString() {
        return " " + mode + tonic.name().replace("_", "#");
    }

    public int getSortingWeight() {
        return sortingWeight;
    }
}
