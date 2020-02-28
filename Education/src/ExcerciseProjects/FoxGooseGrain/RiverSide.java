package ExcerciseProjects.FoxGooseGrain;

public class RiverSide {
    private boolean[] members = new boolean[4];
    private String[] memberNames = new String[]{"GAZDA", "RÓKA", "LIBA", "BÚZA"};
    private String sideName = "";
    public static final int FARMER = 0;
    public static final int FOX = 1;
    public static final int GOOSE = 2;
    public static final int GRAIN = 3;

    public RiverSide(String sideName, boolean full) {
        this.sideName = sideName;
        setAllMembers(full);
    }

    public void setAllMembers(boolean b) {
        for (int i = FARMER; i <= GRAIN; i++) {
            members[i] = b;
        }
    }

    public void flipMember(int member) {
        members[member] = !members[member];
        if( member != FARMER){ members[FARMER] = !members[FARMER]; }
    }

    public boolean ifAnyEat() {
        boolean result = false;

        if (!members[FARMER]) {
            if (members[FOX] && members[GOOSE]) {
                result = true;
                System.out.println(sideName + " a róka megette a libát!");
            } else {
                if (members[GOOSE] && members[GRAIN]) {
                    result = true;
                    System.out.println(sideName + " a liba megette a búzát!");
                }
            }
        }

        return result;
    }

    public boolean ifAllIsHere() {
        boolean result = true;
        for (int i = FARMER; i <= GRAIN; i++) {
            result = result && members[i];
        }

        return result;
    }

    public void printMembers() {
        System.out.print(sideName + ": ");
        for (int i = FARMER; i <= GRAIN; i++) {
            if (members[i]) {
                System.out.print(memberNames[i] + " ");
            }

        }
        System.out.println();
    }

    public boolean ifHere( int member) {
        return this.members[member] && this.members[FARMER];
    }
}
