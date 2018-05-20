package org.javiermf.tuenti8.challenge6.bruteforce.game;

import lombok.Data;

@Data
public class UserAction {

    private final int round;
    private final PulseDirection direction;

    public boolean isBetween(int hitStart, int hitEnd) {
        return (hitStart < round) && (round < hitEnd);
    }


    public enum PulseDirection {
        UP,
        DOWN
    }

}
