package org.javiermf.tuenti8.challenge6.graph;

import lombok.Getter;


@Getter
public class Note {

    private final int initPos;
    private final int length;
    private final int speed;
    private final int score;

    private int hitStart;
    private int hitEnd;

    public Note(int initPos, int length, int speed, int score) {
        this.initPos = initPos;
        this.length = length;
        this.speed = speed;
        this.score = score;
        initHitRounds();
    }

    private void initHitRounds() {
        this.hitStart = initPos / speed;
        this.hitEnd = hitStart + (length / speed);
    }

}
