package org.javiermf.tuenti8.challenge4;

import org.javiermf.tuenti8.challenge4.squares.Square;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class DistanceCalculator {

    private final Board board;
    private final Square source;
    private final Square target;

    public DistanceCalculator(Board board, Square source, Square target) {
        this.board = board;
        this.source = source;
        this.target = target;
    }

    public Optional<Integer> minDistance() {
        int minDistance = 0;
        source.visited();

        Set<Square> evaluatingSquares = new HashSet<>();
        evaluatingSquares.add(source);

        while (!evaluatingSquares.isEmpty()) {

            if (evaluatingSquares.contains(target)) {
                return Optional.of(minDistance);
            }

            Set<Square> nextRoundSquares = nextRoundSquares(evaluatingSquares);

            minDistance++;
            evaluatingSquares = nextRoundSquares;
        }

        return Optional.empty();
    }

    private Set<Square> nextRoundSquares(Set<Square> evaluatingSquares) {
        Set<Square> nextRoundSquares = new HashSet<>();
        for (Square aSquare : evaluatingSquares) {
            for (Position position : aSquare.getJumpingPositions()) {
                if (board.isValid(position)) {
                    Square square = board.getSquareAt(position);
                    if (!square.isVisited()) {
                        square.visited();
                        nextRoundSquares.add(square);
                    }
                }
            }
        }
        return nextRoundSquares;
    }
}
