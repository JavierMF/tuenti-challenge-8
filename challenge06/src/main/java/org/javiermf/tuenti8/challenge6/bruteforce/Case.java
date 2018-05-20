package org.javiermf.tuenti8.challenge6.bruteforce;

import org.javiermf.tuenti8.challenge6.bruteforce.game.Game;
import org.javiermf.tuenti8.challenge6.bruteforce.game.GameEvaluator;
import org.javiermf.tuenti8.challenge6.bruteforce.game.Note;
import org.javiermf.tuenti8.challenge6.bruteforce.game.UserAction;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.javiermf.tuenti8.challenge6.bruteforce.game.UserAction.PulseDirection.UP;

public class Case {

    Set<Note> notes = new HashSet<>();

    public void addNote(int initPos, int length, int speed, int score) {
        notes.add(new Note(initPos, length, speed, score));
    }

    public int maxScore() {
        return bestGame().getGameScore();
    }

    public Game bestGame() {
        List<UserAction> noteActions = notes.stream()
                .flatMap(Note::getActions)
                .collect(toSet()).stream()
                .sorted(comparing(UserAction::getRound))
                .collect(toList());

        GameEvaluator gameEvaluator = new GameEvaluator(notes);
        List<UserAction> initialActions = asList(new UserAction(-1, UP));

        Game game = new Game(initialActions, noteActions, gameEvaluator);
        return game.bestGame();
    }

    public void addNote(String noteLine) {
        List<Integer> val = Arrays.stream(noteLine.split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        addNote(val.get(0), val.get(1), val.get(2), val.get(3));
    }

    public Set<Note> getNotes() {
        return notes;
    }
}
