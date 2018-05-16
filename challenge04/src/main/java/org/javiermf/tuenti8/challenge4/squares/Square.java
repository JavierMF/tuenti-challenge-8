package org.javiermf.tuenti8.challenge4.squares;


import org.javiermf.tuenti8.challenge4.Position;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Square {

    private boolean visited = false;
    private Position position;
    private SquareContents contents;

    public Square(Position position, SquareContents contents) {
        this.position = position;
        this.contents = contents;
    }

    public SquareContents getContents() {
        return contents;
    }

    public void visited() {
        this.visited = true;
    }

    public boolean isVisited() {
        return visited;
    }

    public Set<Position> getJumpingPositions() {
        if (contents == SquareContents.TRAMPOLINE) {
            return positionWithSteps(4, 2);
        } else {
            return positionWithSteps(2, 1);
        }
    }

    private Set<Position> positionWithSteps(int longStep, int shortStep) {
        int baseRow = position.getRow();
        int baseCol = position.getCol();

        Set<Position> positions = new HashSet<>();
        positions.add(new Position(baseRow + longStep, baseCol + shortStep));
        positions.add(new Position(baseRow + longStep, baseCol - shortStep));
        positions.add(new Position(baseRow - longStep, baseCol + shortStep));
        positions.add(new Position(baseRow - longStep, baseCol - shortStep));

        positions.add(new Position(baseRow + shortStep, baseCol + longStep));
        positions.add(new Position(baseRow + shortStep, baseCol - longStep));
        positions.add(new Position(baseRow - shortStep, baseCol + longStep));
        positions.add(new Position(baseRow - shortStep, baseCol - longStep));

        return positions;

    }

    public boolean isValidTarget() {
        return contents != SquareContents.LAVA;
    }

    public Square aCopy() {
        return new Square(position, contents);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (!getClass().equals(o.getClass()))) {
            return false;
        }
        Square square = (Square) o;
        return Objects.equals(position, square.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
