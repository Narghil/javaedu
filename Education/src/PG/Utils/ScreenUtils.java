package PG.Utils;

import java.io.IOException;

public class ScreenUtils {
    public static void cls() {
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
}
