package org.javiermf.tuenti8.challenge4;

import java.util.Objects;

public class Position {

    int row, col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isInLimits(int rowsConstraint, int columnsConstraint) {
        return isInBound(this.row, rowsConstraint)
                && isInBound(this.col, columnsConstraint);
    }

    private boolean isInBound(int pos, int max) {
        return (pos >= 0) && (pos < max);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (!getClass().equals(o.getClass()))) {
            return false;
        }
        Position position = (Position) o;
        return (row == position.row) &&
                (col == position.col);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
