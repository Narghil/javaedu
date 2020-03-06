package Private.Chess;
import Private.Chess.GameLogic.ValidSteps;

public class Chess {

    public static void game() {
        Table table = new Table();
        ValidSteps validsteps = new ValidSteps();
        table.drawTable();
        validsteps.ifValidStep(table,0,0,0,0);
    }

    public static void main(String[] args) {
        game();
    }
}

