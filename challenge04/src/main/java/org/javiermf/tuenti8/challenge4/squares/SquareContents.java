package org.javiermf.tuenti8.challenge4.squares;

public enum SquareContents {

    REGULAR('.'),
    TRAMPOLINE('*'),
    KNIGHT('S'),
    LAVA('#'),
    PRINCESS('P'),
    DESTINATION('D');

    private final char boardChar;

    SquareContents(char boardChar) {
        this.boardChar = boardChar;
    }

    public static SquareContents fromChar(char c) {
        for (SquareContents squareContents : SquareContents.values()) {
            if (squareContents.isChar(c)) {
                return squareContents;
            }
        }
        return null;
    }

    private boolean isChar(char c) {
        return c == boardChar;
    }
}
