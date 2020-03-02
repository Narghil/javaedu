package Private.Chess;

import static Private.Chess.Constants.*;

public abstract class Figure {

    protected class Direction {
        int directionX;
        int directionY;
        Boolean repeating;

        public Direction(int dx, int dy, boolean repeating) {
            directionX = dx;
            directionY = dy;
            this.repeating = repeating;
        }
    }

    protected int side, figureType, row, column, steps;
    protected String representer;
    protected Direction[] movementPattern;

    public int getSide() {
        return side;
    }

    public int getFigureType() {
        return figureType;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setCoordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void drawMe() {
        System.out.print(this.representer);
    }

    public Figure(int side, int figureType, int row, int column) {
        this.figureType = figureType;
        this.side = side;
        this.steps = 0;
        setCoordinates(row, column);
    }

    public int[][] getValidMovements() {
        return null;
    }

}

class NoFigure extends Figure {
    public NoFigure(int row, int column) {
        super(NOFIGURE, NOSIDE, row, column);
        this.representer = " ";
        movementPattern = new Direction[0];
    }
}

class Pawn extends Figure {
    public Pawn(int side, int row, int column) {
        super(PAWN, side, row, column);
        if (side == WHITE) {
            representer = "P";
        } else {
            representer = "p";
        }
        movementPattern = new Direction[4];
        movementPattern[0] = new Direction(0, 1, false);
        movementPattern[1] = new Direction(0, 2, false);
        movementPattern[2] = new Direction(-1, 1, false);
        movementPattern[3] = new Direction(1, 1, false);
    }

    //A PAWN különleges módon mozog!
    @Override
    public int[][] getValidMovements() {
        return null;
    }

}

class Knight extends Figure {
    public Knight(int side, int row, int column) {
        super(KNIGHT, side, row, column);
        //K for King. N for the (K)Night
        if (side == WHITE) {
            representer = "N";
        } else {
            representer = "n";
        }
    }
}

class Bishop extends Figure {
    public Bishop(int side, int row, int column) {
        super(BISHOP, side, row, column);
        if (side == WHITE) {
            representer = "B";
        } else {
            representer = "b";
        }
    }
}

class Rook extends Figure {
    public Rook(int side, int row, int column) {
        super(ROOK, side, row, column);
        if (side == WHITE) {
            representer = "R";
        } else {
            representer = "r";
        }
    }
}

class Queen extends Figure {
    public Queen(int side, int row, int column) {
        super(QUEEN, side, row, column);
        if (side == WHITE) {
            representer = "Q";
        } else {
            representer = "q";
        }
    }
}

class King extends Figure {
    public King(int side, int row, int column) {
        super(KING, side, row, column);
        if (side == WHITE) {
            representer = "K";
        } else {
            representer = "k";
        }
    }
}
