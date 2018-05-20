package org.javiermf.tuenti8.challenge6.bruteforce.game;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class GameEvaluator {

    private final Set<Note> gameNotes;

    public int scoreFor(List<UserAction> userActions) {
        return gameNotes.stream()
                .filter(n -> n.isHittedByUser(userActions))
                .mapToInt(Note::getScore)
                .sum();
    }
}
