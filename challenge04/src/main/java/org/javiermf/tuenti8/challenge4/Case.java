package org.javiermf.tuenti8.challenge4;

import org.javiermf.tuenti8.challenge4.squares.Square;
import org.javiermf.tuenti8.challenge4.squares.SquareContents;

import java.util.Optional;

public class Case {

    Square princess;
    Square destination;
    Square knight;

    Board board;

    private static final String IMPOSSIBLE_RESULT = "IMPOSSIBLE";

    public Case(Board board) {
        this.board = board;
    }

    public void addRow(int i, String caseRow) {
        for (int j = 0; j < caseRow.length(); j++) {
            Position position = new Position(i, j);
            Square square = new Square(position, SquareContents.fromChar(caseRow.charAt(j)));
            saveIfCharacter(square);
            board.add(position, square);
        }
    }

    private void saveIfCharacter(Square square) {
        switch (square.getContents()) {
            case KNIGHT:
                this.knight = square;
                break;
            case PRINCESS:
                this.princess = square;
                break;
            case DESTINATION:
                this.destination = square;
                break;
        }
    }

    public String minSteps() {
        Optional<Integer> goingToPrincess = fromKnightToPrincess();
        if (!goingToPrincess.isPresent()) {
            return IMPOSSIBLE_RESULT;
        }

        Optional<Integer> goingToDestination = fromPrincessToDestination();
        if (!goingToDestination.isPresent()) {
            return IMPOSSIBLE_RESULT;
        }

        return String.valueOf(goingToDestination.get() + goingToPrincess.get());
    }

    protected Optional<Integer> fromPrincessToDestination() {
        DistanceCalculator distanceCalculator = new DistanceCalculator(board.aCopy(), princess, destination);
        return distanceCalculator.minDistance();
    }

    protected Optional<Integer> fromKnightToPrincess() {
        DistanceCalculator distanceCalculator = new DistanceCalculator(board.aCopy(), knight, princess);
        return distanceCalculator.minDistance();
    }
}
