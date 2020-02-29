package Private.Chess;

import static Private.Chess.Constants.*;

public abstract class Figure {

    protected class Direction{
        int directionX;
        int directionY;
        Boolean repeating;
        Boolean onFirstMove;
        Boolean onCapturing;

        public Direction( int dx, int dy, boolean repeating, boolean onFirstMove, boolean onCapturing ){
            directionX = dx; directionY = dy;
            this.repeating = repeating; this.onFirstMove = onFirstMove; this.onCapturing = onCapturing;
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
        //this.ownerTable = ownerTable;
        this.figureType = figureType;
        this.side = side;
        this.steps = 0;
        setCoordinates(row, column);
    }

    abstract public int[][] getValidMovements(); //A movementPattern miatt ez lehet, hogy nem is kell, hogy abstract legyen.
    abstract public boolean ifValidMovement( int row, int column); //Akkor viszont ez sem az.
}

class NoFigure extends Figure {
    public NoFigure(Table ownerTable, int row, int column) {
        super(ownerTable, NOFIGURE, NOSIDE, row, column);
        this.representer = " ";
    }
    public int[][] getValidMovements(){ return null; }
    public boolean ifValidMovement( int row, int column){ return false; }
}

class Pawn extends Figure {
    public Pawn(Table ownerTable, int side, int row, int column) {
        super(ownerTable, PAWN, side, row, column);
        if( side == WHITE){ representer = "P"; } else { representer = "p"; }
        movementPattern = new Direction[4];
        //A PAWN különleges: Az onCapturing = false pattern szerint nem üthet.
        //Ezt az jelzi, hogy VAN oncapturing = true patternje.
        movementPattern[0] = new Direction(  0,1,false,false,false);
        movementPattern[1] = new Direction(  0,2,false,true,false);
        movementPattern[2] = new Direction( -1,1,false,false,true);
        movementPattern[3] = new Direction(  1,1,false,false,true);
    }
    public int[][] getValidMovements(){ return null; }
    public boolean ifValidMovement( int row, int column){ return false; }

}

class Knight extends Figure {
    public Knight(Table ownerTable, int side, int row, int column) {
        super(ownerTable, KNIGHT, side, row, column);
        //K for King. N for the (K)Night
        if( side == WHITE){ representer = "N"; } else { representer = "n"; }
    }
    public int[][] getValidMovements(){ return null; }
    public boolean ifValidMovement( int row, int column){ return false; }
}

class Bishop extends Figure {
    public Bishop(Table ownerTable, int side, int row, int column) {
        super(ownerTable, BISHOP, side, row, column);
        if( side == WHITE){ representer = "B"; } else { representer = "b"; }
    }
    public int[][] getValidMovements(){ return null; }
    public boolean ifValidMovement( int row, int column){ return false; }
}

class Rook extends Figure {
    public Rook(Table ownerTable, int side, int row, int column) {
        super(ownerTable, ROOK, side, row, column);
        if( side == WHITE){ representer = "R"; } else { representer = "r"; }
    }
    public int[][] getValidMovements(){ return null; }
    public boolean ifValidMovement( int row, int column){ return false; }
}

class Queen extends Figure {
    public Queen(Table ownerTable, int side, int row, int column) {
        super(ownerTable, QUEEN, side, row, column);
        if( side == WHITE){ representer = "Q"; } else { representer = "q"; }
    }
    public int[][] getValidMovements(){ return null; }
    public boolean ifValidMovement( int row, int column){ return false; }
}

class King extends Figure {
    public King(Table ownerTable, int side, int row, int column) {
        super(ownerTable, KING, side, row, column);
        if( side == WHITE){ representer = "K"; } else { representer = "q"; }
    }
    public int[][] getValidMovements(){ return null; }
    public boolean ifValidMovement( int row, int column){ return false; }
    public boolean ifInCheck(){ return false;}
    public boolean ifCheckMate(){return false;}
}
