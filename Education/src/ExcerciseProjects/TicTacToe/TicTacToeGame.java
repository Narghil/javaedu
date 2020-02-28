package ExcerciseProjects.TicTacToe;

import ExcerciseProjects.TicTacToe.TicTacToeInput;

import java.util.Scanner;

public class TicTacToeGame {
    public static void game(int row, int column, int win) {
        TicTacToeTable gameTable;
        TicTacToeInput gameInput;
        String currentPlayer = "X", inputLine;
        boolean endGame = false;
        Scanner scanner = new Scanner(System.in);

        gameTable = new TicTacToeTable(row, column, win);
        gameInput = new TicTacToeInput();

        while (!endGame) {
            gameTable.drawTable();
            System.out.print(currentPlayer + " következik. Formátum: <sor,oszlop>:");
            inputLine = scanner.nextLine();
            System.out.println();
            if (gameInput.validUserParams(inputLine, gameTable.getRows(), gameTable.getCols())) {
                if ("q".equalsIgnoreCase(inputLine)) {
                    endGame = true;
                    System.out.println("Ön kilépett. Sajnálom.");
                    break;
                }
                if (gameTable.setStone(gameInput.getUserParRow(), gameInput.getUserParCol(), currentPlayer)) {
                    if( gameTable.ifGameWinned()){
                        endGame = true;
                        gameTable.drawTable();
                        System.out.println(currentPlayer+" GYŐZÖTT!");
                        break;
                    } else{
                        if (currentPlayer == "X") {
                            currentPlayer = "O";
                        } else {
                            currentPlayer = "X";
                        }
                    }
                }
            }
        }
    }
}
