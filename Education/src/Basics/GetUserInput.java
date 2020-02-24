package Basics;

import java.util.Scanner;

public class GetUserInput {

    public static void main(String[] args) {
//        basicScanning();
        continuousScanning();
    }

    static void basicScanning() {
        Scanner scanner = new Scanner(System.in);

        // Célszerű valami hint-et adni a user-nek, hogy mi történik...
        System.out.println("Várom a bevitelt!");
        String userInput = scanner.nextLine();
        System.out.println("Ezt írtad be: " + userInput);
    }

    static void continuousScanning() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Várom a bevitelt!");

        while (true) {
            String userInput = scanner.nextLine();
            if ("q".equalsIgnoreCase(userInput)) {
                System.out.println("Exiting now...");
                System.exit(0);
            } else {
                System.out.println("Ezt írtad be: " + userInput);
            }
        }
    }
}