package HomeWork.hu.PG.platenumbers;

import HomeWork.hu.PG.platenumbers.Issuer;

import java.util.Random;
import java.util.Scanner;

public class PlateNumbers {
    public static void main(String[] args) {
        Issuer issuer = new Issuer();
        Random random = new Random();
        Scanner scanner = new Scanner( System.in );
        int j;

        try {
            System.out.print("Hány rendszámot kérsz?:");
            j = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < j; i++) {
                System.out.println(issuer.requirePlateNumber().getFullPlateNumber());
            }
        } catch( NumberFormatException e ){
            System.out.println("Nem számot írtál be!");
        }
    }
}

/*
hu.[saját_neved].PlateNumbers:
 - itt írd meg a program belépési pontját (main metódust); igényelj néhány rendszámot az Issuer-től és írasd ki őket;
 */