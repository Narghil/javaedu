package ExcerciseProjects.TicTacToe;

class TicTacToeInput {
    private int userParRow, userParCol;
    private int mainParRow, mainParCol, mainParWin;

    public int getUserParRow() {
        return userParRow;
    }

    public int getUserParCol() {
        return userParCol;
    }

    public int getMainParRow() {
        return mainParRow;
    }

    public int getMainParCol() {
        return mainParCol;
    }

    public int getMainParWin() {
        return mainParWin;
    }

    public boolean validMainParams(String[] args) {
        boolean result=true;
        int maxWins;

        if( args.length != 3){ result = false; }
        try{
            mainParRow = Integer.parseInt(args[0]);
            mainParCol = Integer.parseInt(args[1]);
            mainParWin = Integer.parseInt(args[2]);
        } catch( Exception e){
            result = false;
        }
        if( ! result ){
            System.out.println("Három paramétert kell megadni! Formátum:<sorok oszlopok győzelem>");
        } else {
            if(mainParRow < 8 || mainParRow > 20) {
                result = false;
                System.out.println("A sorok számának 8 és 20 között kell lennie!");
            }
            if(mainParCol < 8 || mainParCol > 20) {
                result = false;
                System.out.println("Az oszlopok számának 8 és 20 között kell lennie!");
            }
            maxWins = mainParRow;
            if( mainParCol > maxWins){ maxWins = mainParCol; }
            if( mainParWin > maxWins || maxWins < 5){
                result = false;
                System.out.println("A győzelemhez szükséges kövek számának 5 és "+maxWins+" között kell lennie!");
            }

        }

        return result;
    }

    public boolean validUserParams(String arg, int rows, int cols) {
        String[] args;

        if ("q".equalsIgnoreCase(arg)) {
            return true;
        }
        args = arg.split(",");
        if (args.length != 2) {
            System.out.println("Hibás bevitel! Pontosan két számot kell megadni!");
            return false;
        }
        try {
            userParRow = Integer.parseInt(args[0]);
            userParCol = Integer.parseInt(args[1]);
        } catch (Exception e) {
            System.out.println("Hibás bevitel! Számokat kell megadni!");
            return false;
        }
        if (userParRow < 1 || userParRow > rows) {
            System.out.println(String.format("Hibás bevitel! A sorok számának 1 és %1d között kell lennie!", rows));
            return false;
        }
        if (userParCol < 1 || userParCol > cols) {
            System.out.println(String.format("Hibás bevitel! Az oszlopok számának 1 és %1d között kell lennie!", cols));
            return false;
        }

        return true;
    }

}
