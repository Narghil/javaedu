package Private.Chess;

import static Private.Chess.Constants.*;

public abstract class Figure {

    protected class Direction{
        int directionX;
        int directionY;
        Boolean repeating;

        public Direction( int dx, int dy, boolean repeating ){
            directionX = dx; directionY = dy;
            this.repeating = repeating;
        }
    }

    protected Table ownerTable;
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

    public void drawMe(){
        System.out.print(this.representer);
    }

    public Figure(Table ownerTable, int side, int figureType, int row, int column) {
        this.ownerTable = ownerTable;
        this.figureType = figureType;
        this.side = side;
        this.steps = 0;
        setCoordinates(row, column);
    }

    public int[][] getValidMovements(){return null;};
    public boolean ifValidMovement( int row, int column){return false;};
}

class NoFigure extends Figure {
    public NoFigure(Table ownerTable, int row, int column) {
        super(ownerTable, NOFIGURE, NOSIDE, row, column);
        this.representer = " ";
        movementPattern = new Direction[0];
    }
}

class Pawn extends Figure {
    public Pawn(Table ownerTable, int side, int row, int column) {
        super(ownerTable, PAWN, side, row, column);
        if( side == WHITE){ representer = "P"; } else { representer = "p"; }
        //A PAWN különleges módon mozog!
        movementPattern = new Direction[4];
        movementPattern[0] = new Direction(  0,1,false);
        movementPattern[1] = new Direction(  0,2,false);
        movementPattern[2] = new Direction( -1,1,false);
        movementPattern[3] = new Direction(  1,1,false);
    }
    @Override
    public int[][] getValidMovements(){ return null; }

}

class Knight extends Figure {
    public Knight(Table ownerTable, int side, int row, int column) {
        super(ownerTable, KNIGHT, side, row, column);
        //K for King. N for the (K)Night
        if( side == WHITE){ representer = "N"; } else { representer = "n"; }
    }
}

class Bishop extends Figure {
    public Bishop(Table ownerTable, int side, int row, int column) {
        super(ownerTable, BISHOP, side, row, column);
        if( side == WHITE){ representer = "B"; } else { representer = "b"; }
    }
}

class Rook extends Figure {
    public Rook(Table ownerTable, int side, int row, int column) {
        super(ownerTable, ROOK, side, row, column);
        if( side == WHITE){ representer = "R"; } else { representer = "r"; }
    }
}

class Queen extends Figure {
    public Queen(Table ownerTable, int side, int row, int column) {
        super(ownerTable, QUEEN, side, row, column);
        if( side == WHITE){ representer = "Q"; } else { representer = "q"; }
    }
}

class King extends Figure {
    public King(Table ownerTable, int side, int row, int column) {
        super(ownerTable, KING, side, row, column);
        if( side == WHITE){ representer = "K"; } else { representer = "q"; }
    }
    public boolean ifInCheck(){ return false;}
    public boolean ifCheckMate(){return false;}
}
