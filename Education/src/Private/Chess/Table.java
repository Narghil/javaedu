package Private.Chess;

import static Private.Chess.Constants.*;

public class Table {

    private int rows = 8, columns = 8;
    public Figure[][] pieces = new Figure[rows][columns];

    private void PlacePawns(int side, int row) {
        for (int c = 0; c < columns; c++) {
            pieces[row][c] = new Pawn(this, side, row, c);
        }
    }

    private void PlaceOtherFigures(int side, int row) {
        pieces[row][0] = new Rook(this, side, row, 0);
        pieces[row][7] = new Rook(this, side, row, 7);
        pieces[row][1] = new Knight(this, side, row, 1);
        pieces[row][6] = new Knight(this, side, row, 6);
        pieces[row][2] = new Bishop(this, side, row, 2);
        pieces[row][5] = new Bishop(this, side, row, 5);
        pieces[row][3] = new Queen(this, side, row, 3);
        pieces[row][4] = new King(this, side, row, 4);
    }

    private void FillTable() {
        //Ebben az implementációban Világos az 1-2., Sötét a 7-8. sorban áll.
        int row;
        //Empty pieces
        for (int r = 2; r < 6; r++) {
            for (int c = 0; c < columns; c++) {
                pieces[r][c] = new NoFigure(this, r, c);
                ;
            }
        }
        PlacePawns(WHITE, 1);
        PlaceOtherFigures(WHITE, 0);
        PlacePawns(BLACK, 6);
        PlaceOtherFigures(BLACK, 7);
    }

    public Table() {
        FillTable();
    }

}
