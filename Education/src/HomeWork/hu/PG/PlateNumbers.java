package HomeWork.hu.PG;

import HomeWork.hu.PG.platenumbers.Issuer;

import java.util.Random;

public class PlateNumbers {
    public static void main(String[] args) {
        Issuer issuer = new Issuer();
        Random random = new Random();

        for( int i=0; i < random.nextInt(10) +1; i++) {
            System.out.println(issuer.requirePlateNumber().getFullPlateNumber());
        }
    }
}

/*

hu.[saját_neved].PlateNumbers:
 - itt írd meg a program belépési pontját (main metódust); igényelj néhány rendszámot az Issuer-től és írasd ki őket;
 */