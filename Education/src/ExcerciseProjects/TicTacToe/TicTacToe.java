package ExcerciseProjects.TicTacToe ;

class TicTacToe {
    public static void main(String[] args) {
        TicTacToeInput gameInput = new TicTacToeInput();
        TicTacToeGame tttGame = new TicTacToeGame();
        if (gameInput.validMainParams(args)) {
            tttGame.game(gameInput.getMainParRow(), gameInput.getMainParCol(), gameInput.getMainParWin());
        }

    }
}
