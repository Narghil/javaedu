package HomeWork.hu.PG.platenumbers.generator;

import java.util.Random;

public class PlateNumberGenerator {
    public static String[] getPlateNumber(){
        String letterPart="";
        String numberPart="";
        char c ;
        Random r = new Random();

        for(int i = 0; i<3; i++){
            c = (char)(r.nextInt( ('Z'-'A')+1 )+'A');
            letterPart = letterPart + c;
            c = (char)(r.nextInt( ('9'-'0')+1 )+'0');
            numberPart = numberPart + c;
        }

        return new String[]{letterPart, numberPart};
    }
}

/*
hu.platenumbers.generator.PlateNumberGenerator:
        - egyetlen static metódust tartalmazzon, ami egy kételemű String[] tömböt ad vissza;
        a visszaadott tömb 0. eleme legyen a rendszám 3 betűből álló része, az 1. eleme pedig a rendszám 3 számból álló része;
*/
