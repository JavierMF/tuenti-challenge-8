package org.javiermf.tuenti8.challenge1;

public class Waffle {

    private final int verticalLines;
    private final int horizontalLines;

    public Waffle(int verticalLines, int horizontalLines) {
        this.verticalLines = verticalLines;
        this.horizontalLines = horizontalLines;
    }

    public int squares() {
        return (verticalLines - 1) * (horizontalLines - 1);
    }
}
