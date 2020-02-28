package ExcerciseProjects.TicTacToe;

class TicTacToeTable {
    private int rows, columns, winCount;
    private int[][] stones;

    public TicTacToeTable(int rows, int columns, int winCount) {
        this.rows = rows;
        this.columns = columns;
        this.winCount = winCount;
        this.stones = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                stones[i][j] = 0;
            }
        }
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.columns;
    }

    private void drawSeparatorLine() {
        String s;

        s = "";
        for (int c = 0; c <= this.columns; c++) {
            s = s + "---+";
        }
        System.out.println(s);
    }

    public void drawTable() {
        int c, r;
        String s;
        //columns header;
        System.out.print("   ");
        for (c = 1; c <= this.columns; c++) {
            System.out.print(String.format("|%1$2d.", c));
        }
        System.out.println("|");
        //rows with row count indicators
        for (r = 0; r < this.rows; r++) {
            drawSeparatorLine();
            //drawing the row
            s = String.format("%1$2d.|", r + 1);
            for (c = 0; c < this.columns; c++) {
                if (this.stones[r][c] == 0) {
                    s = s + "   ";
                }
                if (this.stones[r][c] == 1) {
                    s = s + " X ";
                }
                if (this.stones[r][c] == 2) {
                    s = s + " O ";
                }
                s = s + "|";
            }
            System.out.println(s);
        }
        drawSeparatorLine();
    }

    public boolean setStone(int row, int column, String player) {
        if (this.stones[row - 1][column - 1] != 0) {
            System.out.println("Ez a pozíció már foglalt, adjon meg másikat!");
            return false;
        }
        if (player.equals("X")) {
            this.stones[row - 1][column - 1] = 1;
        }
        if (player.equals("O")) {
            this.stones[row - 1][column - 1] = 2;
        }
        return true;
    }

    public String giveSequence(int startRow, int startCol, int stepRow, int stepCol) {
        int actRow, actCol;
        String Sequence = "";

        actRow = startRow;
        actCol = startCol;
        while (actRow >= 0 && actRow < this.rows && actCol >= 0 && actCol < this.columns) {
            if (this.stones[actRow][actCol] == 0) {
                Sequence = Sequence.concat(" ");
            }
            if (this.stones[actRow][actCol] == 1) {
                Sequence = Sequence.concat("X");
            }
            if (this.stones[actRow][actCol] == 2) {
                Sequence = Sequence.concat("O");
            }
            actRow = actRow + stepRow;
            actCol = actCol + stepCol;
        }

        return Sequence;
    }

    public boolean ifGameWinned() {
        String sequence = "", winSequenceX = "", winSequenceO = "";

        for (int i = 1; i <= this.winCount; i++) {
            winSequenceX = winSequenceX.concat("X");
            winSequenceO = winSequenceO.concat("O");
        }
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.columns; col++) {
                for (int stepRow = -1; stepRow <= 1; stepRow++) {
                    for (int stepCol = -1; stepCol <= 1; stepCol++) {
                        if (stepRow != 0 || stepCol != 0) {
                            sequence = giveSequence(row, col, stepRow, stepCol);
                            if (sequence.contains(winSequenceX) || sequence.contains(winSequenceO)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

} //Class end