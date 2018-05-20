package org.javiermf.tuenti8.challenge6.bruteforce.game.printer;

import lombok.Data;
import org.javiermf.tuenti8.challenge6.bruteforce.game.Note;

@Data
public class NotePrinter {

    private final Note note;
    private int noteStartAt;
    private int noteEndAt;


    public NotePrinter(Note note) {
        this.note = note;
        this.noteStartAt = note.getInitPos();
        this.noteEndAt = this.noteStartAt + note.getLength();
    }

    public boolean isVisible() {
        return noteEndAt >= 0;
    }

    public String nextRoundResult() {
        StringBuilder builder = buildNoteState();

        this.noteStartAt -= note.getSpeed();
        this.noteEndAt -= note.getSpeed();

        return builder.toString();
    }

    private StringBuilder buildNoteState() {
        int noteLengthToPrint = getNoteLengthToPrint();

        StringBuilder builder = new StringBuilder();
        builder.append(twoDigs(noteStartAt)).append("_").append(twoDigs(noteEndAt));
        builder.append("|");
        builder.append(stringTimes(".", noteStartAt));
        builder.append(stringTimes(String.valueOf(note.getScore()), noteLengthToPrint));
        return builder;
    }

    private int getNoteLengthToPrint() {
        int noteLengthToPrint;
        if (noteEndAt <= 0) {
            noteLengthToPrint = 0;
        } else {
            if (noteEndAt < note.getLength()) {
                noteLengthToPrint = noteEndAt;
            } else {
                noteLengthToPrint = note.getLength();
            }
        }
        return noteLengthToPrint;
    }

    private String twoDigs(int value) {
        return String.format("%03d", value);
    }

    private String stringTimes(String c, int repeatTimes) {
        if (repeatTimes <= 0) {
            return "";
        }
        return new String(new char[repeatTimes]).replace("\0", c);
    }
}
