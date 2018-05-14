package org.javiermf.tuenti8.challenge3;

import java.util.Arrays;
import java.util.List;

public enum Note {

    C(0, "C", "B#"),
    C_(1, "C#", "Db"),
    D(2, "D"),
    D_(3, "D#", "Eb"),
    E(4, "E", "Fb"),
    F(5, "F", "E#"),
    F_(6, "F#", "Gb"),
    G(7, "G"),
    G_(8, "G#", "Ab"),
    A(9, "A"),
    A_(10, "A#", "Bb"),
    B(11, "B", "Cb");


    private final int pos;
    private final int weight;
    private final List<String> names;

    Note(int pos, String... names) {
        this.pos = pos;
        this.names = Arrays.asList(names);
        this.weight = (pos + 3) % 12;
    }

    public static Note forPos(int pos) {
        for (Note note : Note.values()) {
            if (note.getPos() == pos) {
                return note;
            }
        }
        return null; // TODO: Use optional
    }

    public int getPos() {
        return pos;
    }


    public static Note forName(String stringNote) {
        for (Note note : Note.values()) {
            if (note.isForString(stringNote)) {
                return note;
            }
        }
        return null; // TODO: Utilizar optionals
    }

    private boolean isForString(String stringNote) {
        return names.contains(stringNote);
    }

    public int weight() {
        return weight;
    }
}
