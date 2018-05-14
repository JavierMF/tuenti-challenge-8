package org.javiermf.tuenti8.challenge3.scales;

import org.javiermf.tuenti8.challenge3.Note;

import java.util.HashSet;
import java.util.Set;

public class ScaleFactory {

    private static final int ALL_NOTES = Note.values().length;

    private Set<Scale> scales = new HashSet<>();

    public ScaleFactory() {
        for (Note note : Note.values()) {
            scales.add(buildScale(note, ScaleMode.MAJOR));
            scales.add(buildScale(note, ScaleMode.MINOR));
        }
    }

    protected Scale buildScale(Note note, ScaleMode mode) {
        Set<Note> notesInScale = buildScaleNotes(note, mode);
        return new Scale(note, mode, notesInScale);
    }

    protected Set<Note> buildScaleNotes(Note note, ScaleMode mode) {
        Set<Note> notesInScale = new HashSet<>();
        notesInScale.add(note);

        int pos = note.getPos();
        for (int step : mode.getSteps()) {
            pos += step;
            Note aNote = Note.forPos(pos % ALL_NOTES);
            notesInScale.add(aNote);
        }

        return notesInScale;
    }

    public Set<Scale> getAllScales() {
        return scales;
    }

    public Scale getScale(Note note, ScaleMode mode) {
        for (Scale scale : scales) {
            if (scale.is(note, mode)) {
                return scale;
            }
        }

        return null;
    }
}
