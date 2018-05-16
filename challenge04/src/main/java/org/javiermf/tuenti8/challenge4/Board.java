package org.javiermf.tuenti8.challenge4;

import org.javiermf.tuenti8.challenge4.squares.Square;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private final int rows;
    private final int columns;
    private Map<Position, Square> squares = new HashMap();

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public void add(Position position, Square square) {
        squares.put(position, square);
    }

    public boolean isValid(Position position) {
        return position.isInLimits(rows, columns) &&
                getSquareAt(position).isValidTarget();
    }

    public Square getSquareAt(Position position) {
        return squares.get(position);
    }

    public Board aCopy() {
        Board copy = new Board(rows, columns);
        for (Map.Entry<Position, Square> entry : squares.entrySet()) {
            copy.add(entry.getKey(), entry.getValue().aCopy());
        }
        return copy;
    }
}
