package Basics;

import java.util.Scanner;
import static java.lang.Math.sqrt;

public class IsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in);
        String inputLine = "";
        int examNumber = 0;
        int sqrtNumber = 0;
        boolean isNotPrime = false;

        try {
            System.out.print("Type the number:");
            inputLine = scanner.nextLine();
            examNumber = Integer.valueOf(inputLine);

            sqrtNumber = (int) sqrt(examNumber);
            isNotPrime = (examNumber % 2 == 0);
            if (!isNotPrime) {
                for (int divider = 3; divider <= sqrtNumber; divider += 2) {
                    isNotPrime = (examNumber % divider == 0);
                    if (isNotPrime) break;
                }
            }
            if (isNotPrime){
                System.out.println("Not a prime number.");} else{
                System.out.println("PRIME NUMBER!");
            };

        } catch (Exception e) {
            System.out.println(inputLine + " not a number!");
        }


    }
}
