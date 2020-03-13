package ExcerciseProjects;

import static PG.Utils.IOUtils.sopl;
import static PG.Utils.StringUtils.replicate;

public class Diamond {
    public enum Tokens { SPACE(" "), STAR("*");
        final String token;
        Tokens( String t ){
            this.token = t;
        }
    }

    public static void main(String[] args) {
        Integer maxLength = examParam(args);
        if (maxLength > 0) {
            printDiamond(maxLength);
        }
    }

    public static Integer examParam(String[] args) {
        Integer maxLength;

        if (args.length != 1) {
            sopl("Hívás: Diamond <N>");
            return 0;
        }

        try {
            maxLength = Integer.valueOf(args[0]);
        } catch (Exception exc) {
            sopl("Hibás formátum vagy nem szám paraméter!");
            return 0;
        }
        if (maxLength % 2 != 1) {
            sopl("Nem pozitív vagy nem páratlan szám!");
            return 0;
        }
        return maxLength;
    }

    public static void printDiamond(Integer len) {
        for (int i = 1; i <= len; i = i + 2) {
            printDiamondLine(len, i);
        }
        for (int i = len - 2; i >= 1; i = i - 2) {
            printDiamondLine(len, i);
        }
    }

    public static void printDiamondLine(Integer len, Integer idx) {
        String spaces = replicate( Tokens.SPACE.token, (len - idx) / 2);
        sopl(spaces + replicate(Tokens.STAR.token, idx) + spaces);
        //String spaces = replicate( " ", (len - idx) / 2);
        //sopl(spaces + replicate("*", idx) + spaces);
    }
}
