package org.javiermf.tuenti8.challenge6.bruteforce.game.printer;

import lombok.Data;
import org.javiermf.tuenti8.challenge6.bruteforce.game.Game;
import org.javiermf.tuenti8.challenge6.bruteforce.game.Note;
import org.javiermf.tuenti8.challenge6.bruteforce.game.UserAction;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.util.Comparator.comparing;
import static org.javiermf.tuenti8.challenge6.bruteforce.game.UserAction.PulseDirection.DOWN;

@Data
public class GamePrinter {

    private final Set<Note> notes;
    private final Game game;
    int round = 0;
    private List<NotePrinter> notePrinters;

    public void print() {
        game.getUserActions()
                .forEach(ua -> System.out.print(ua));

        notePrinters = notes.stream()
                .map(note -> new NotePrinter(note))
                .collect(Collectors.toList());

        while (anyNoteVisible()) {
            System.out.println(format("Round %d", round));

            printUserStateInRound();
            notePrinters.forEach(
                    notePrinter -> System.out.println(notePrinter.nextRoundResult())
            );

            System.out.println();
            round++;
        }
    }

    private void printUserStateInRound() {
        UserAction lastUserAction = game.getUserActions().stream()
                .filter(action -> action.getRound() <= round)
                .max(comparing(UserAction::getRound)).get();

        String userChar = (lastUserAction.getDirection() == DOWN) ? "v" : "-";
        System.out.println("       " + userChar);
    }

    private boolean anyNoteVisible() {
        return notePrinters.stream()
                .anyMatch(NotePrinter::isVisible);
    }
}
