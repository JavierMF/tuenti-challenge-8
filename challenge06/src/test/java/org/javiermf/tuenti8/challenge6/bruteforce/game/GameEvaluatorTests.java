package org.javiermf.tuenti8.challenge6.bruteforce.game;

import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameEvaluatorTests {

    @Test
    public void deberiaCalculaLaPuntuacion() {
        Set<Note> notes = Stream.of(
                new Note(2, 1, 1, 1),
                new Note(3, 1, 1, 2),
                new Note(2, 2, 1, 1)
        ).collect(toSet());

        GameEvaluator gameEvaluator = new GameEvaluator(notes);

        List<UserAction> game1 = asList(
                new UserAction(2, UserAction.PulseDirection.DOWN),
                new UserAction(3, UserAction.PulseDirection.UP)
        );

        assertThat(gameEvaluator.scoreFor(game1), is(1));


        List<UserAction> game2 = asList(
                new UserAction(3, UserAction.PulseDirection.DOWN),
                new UserAction(4, UserAction.PulseDirection.UP)
        );
        assertThat(gameEvaluator.scoreFor(game2), is(2));

        List<UserAction> game3 = asList(
                new UserAction(3, UserAction.PulseDirection.DOWN),
                new UserAction(7, UserAction.PulseDirection.UP)
        );
        assertThat(gameEvaluator.scoreFor(game3), is(0));

    }
}
