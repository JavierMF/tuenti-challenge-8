package org.javiermf.tuenti8.challenge6.bruteforce.game;

import lombok.Data;

import java.util.List;
import java.util.stream.Stream;

@Data
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

    public Stream<UserAction> getActions() {
        return Stream.of(
                new UserAction(hitStart, UserAction.PulseDirection.DOWN),
                new UserAction(hitEnd, UserAction.PulseDirection.UP)
        );
    }

    public boolean isHittedByUser(List<UserAction> userActionList) {
        return getActions()
                .allMatch(userActionList::contains) && noActionsBetween(userActionList, hitStart, hitEnd);
    }

    private boolean noActionsBetween(List<UserAction> userActionList, int hitStart, int hitEnd) {
        return userActionList.stream()
                .noneMatch(userAction -> userAction.isBetween(hitStart, hitEnd));
    }
}
