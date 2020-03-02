package Private.Chess;

import java.io.IOException;

import static Private.Chess.Constants.*;

public class Table {

    private int rows = 8, columns = 8;
    public Figure[][] pieces = new Figure[rows][columns];

    private void placePawns(int side, int row) {
        for (int c = 0; c < columns; c++) {
            pieces[row][c] = new Pawn(side, row, c);
        }
    }

    private void placeotherfigures(int side, int row) {
        pieces[row][0] = new Rook(side, row, 0);
        pieces[row][7] = new Rook(side, row, 7);
        pieces[row][1] = new Knight(side, row, 1);
        pieces[row][6] = new Knight(side, row, 6);
        pieces[row][2] = new Bishop(side, row, 2);
        pieces[row][5] = new Bishop(side, row, 5);
        pieces[row][3] = new Queen(side, row, 3);
        pieces[row][4] = new King(side, row, 4);
    }

    private void fillTable() {
        //Ebben az implementációban Világos az 1-2., Sötét a 7-8. sorban áll.
        //Empty pieces
        for (int r = 2; r < 6; r++) {
            for (int c = 0; c < columns; c++) {
                pieces[r][c] = new NoFigure(r, c);
            }
        }
        placePawns(WHITE, 1);
        placeotherfigures(WHITE, 0);
        placePawns(BLACK, 6);
        placeotherfigures(BLACK, 7);
    }

    public void cls() {
        final String os = System.getProperty("os.name");
        try {
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    public void drawTable() {
        final String headerLine = "     A   B   C   D   E   F   G   H     ";
        final String separator = "   +---+---+---+---+---+---+---+---+   ";

        cls();
        System.out.println(headerLine);
        System.out.println(separator);
        for (int row = 7; row >= 0; row--) {
            System.out.printf(" %1d ", row + 1);
            for (int col = 0; col < this.columns; col++) {
                System.out.print("| ");
                this.pieces[row][col].drawMe();
                System.out.print(" ");
            }
            System.out.printf("| %1d ", row + 1);
            System.out.println();
            System.out.println(separator);
        }
        System.out.println(headerLine);
        System.out.println();
    }

    public Table() {
        fillTable();
    }

}
