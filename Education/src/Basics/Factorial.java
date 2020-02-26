package Basics;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in);
        String inputLine = "";
        int baseNumber = 0;
        double result;

        try {
            System.out.print("Type the base of factorial:");
            inputLine = scanner.nextLine();
            baseNumber = Integer.valueOf(inputLine);
            result = 1.0d;

            for( int i=1; i<=baseNumber; i++){ result = result * i;}
            System.out.println("Factorial:"+result);
        } catch (Exception e) {
            System.out.println(inputLine + " not a number!");
        }


    }
}
