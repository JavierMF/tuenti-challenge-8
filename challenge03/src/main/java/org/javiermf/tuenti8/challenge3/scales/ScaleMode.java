package org.javiermf.tuenti8.challenge3.scales;

public enum ScaleMode {

    MAJOR(2, 2, 1, 2, 2, 2, 1), // WWHWWWH
    MINOR(2, 1, 2, 2, 1, 2, 2); // WHWWHWW

    private final int[] steps;


    ScaleMode(int... steps) {
        this.steps = steps;
    }

    public int[] getSteps() {
        return steps;
    }

    public int weight() {
        return (this == MAJOR) ? 0 : 1000;
    }

    @Override
    public String toString() {
        return (this == MAJOR) ? "M" : "m";
    }
}
