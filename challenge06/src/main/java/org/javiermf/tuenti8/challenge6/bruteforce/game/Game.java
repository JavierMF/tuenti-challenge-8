package org.javiermf.tuenti8.challenge6.bruteforce.game;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.javiermf.tuenti8.challenge6.bruteforce.game.UserAction.PulseDirection.DOWN;
import static org.javiermf.tuenti8.challenge6.bruteforce.game.UserAction.PulseDirection.UP;

@Data
public class Game {

    private final List<UserAction> userActions;
    private final List<UserAction> pendingActions;
    private final GameEvaluator gameEvaluator;
    private int gameScore;

    public Game bestGame() {
        if (pendingActions.isEmpty()) {
            gameScore = gameEvaluator.scoreFor(userActions);
            return this;
        }

        return nextRoundGames()
                .map(Game::bestGame).max(comparing(Game::getGameScore))
                .get();
    }

    private Stream<Game> nextRoundGames() {
        int nextRound = pendingActions.get(0).getRound();

        Set<UserAction> nextRoundActions = nextRoundActions(nextRound);

        UserAction.PulseDirection nextPossibleUserActionDirection = nextDirection();

        boolean canDoNextAction = nextRoundActions.stream()
                .anyMatch(
                        userAction -> userAction.getDirection() == nextPossibleUserActionDirection
                );

        Set<Game> nextRoundGames = new HashSet<>();
        nextRoundGames.add(buildNoActionGameForRound(nextRound));
        if (canDoNextAction) {
            Game doActionGame = buildDoActionGameForRound(nextRound, new UserAction(nextRound, nextPossibleUserActionDirection));
            nextRoundGames.add(doActionGame);
        }

        return nextRoundGames.stream();
    }

    private Game buildDoActionGameForRound(int nextRound, UserAction newUserAction) {
        List<UserAction> userActions = userActionsCopy();
        userActions.add(newUserAction);
        List<UserAction> pendingActions = removeRoundForPendingActions(nextRound);
        return new Game(userActions, pendingActions, gameEvaluator);
    }

    private List<UserAction> removeRoundForPendingActions(int nextRound) {
        return pendingActions.stream().
                filter(action -> action.getRound() != nextRound)
                .collect(toList());
    }

    private List<UserAction> userActionsCopy() {
        return userActions.stream().collect(toList());
    }

    private Game buildNoActionGameForRound(int nextRound) {
        List<UserAction> userActions = userActionsCopy();
        List<UserAction> pendingActions = removeRoundForPendingActions(nextRound);
        return new Game(userActions, pendingActions, gameEvaluator);
    }

    private UserAction.PulseDirection nextDirection() {
        UserAction lastUserAction = userActions.get(userActions.size() - 1);
        return (lastUserAction.getDirection() == UP) ? DOWN : UP;
    }

    private Set<UserAction> nextRoundActions(int nextRound) {
        return pendingActions.stream()
                .filter(userAction -> userAction.getRound() == nextRound)
                .collect(toSet());
    }
}
