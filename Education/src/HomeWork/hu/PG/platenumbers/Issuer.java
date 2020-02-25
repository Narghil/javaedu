package HomeWork.hu.PG.platenumbers;

import HomeWork.hu.PG.platenumbers.model.PlateNumber;
import HomeWork.hu.PG.platenumbers.generator.PlateNumberGenerator;

public class Issuer {
    private PlateNumber releasedPlateNumbers[] = new PlateNumber[0];
    private PlateNumber dummyPN[];
    private int dummyLen;

    public PlateNumber requirePlateNumber(){
        String partsOfPlateNumber[] ;
        PlateNumber aPlateNumber;
        Boolean released;

        do {

            partsOfPlateNumber = PlateNumberGenerator.getPlateNumber();
            aPlateNumber = new PlateNumber(partsOfPlateNumber[0], partsOfPlateNumber[1]);

            released = false;
            for ( int i = 0; i < releasedPlateNumbers.length; i++){
                released = ( releasedPlateNumbers[i].getFullPlateNumber() ==  aPlateNumber.getFullPlateNumber() ) ;
                if( released){ break; }
            }
        } while (released );
        dummyLen = releasedPlateNumbers.length +1;
        dummyPN = new PlateNumber[ dummyLen ];
        System.arraycopy( releasedPlateNumbers, 0, dummyPN, 0, dummyLen -1);
        releasedPlateNumbers = dummyPN;
        releasedPlateNumbers[ dummyLen -1 ] = aPlateNumber;

        return aPlateNumber;
    }
}

/*
hu.platenumbers.Issuer:
        - tartson nyilván egy PlateNumber tömböt, amiben eltárolja a már kiadott rendszámokat;
        - legyen egy requirePlateNumber nevű metódusa, amelyen igényelni lehet egy új, még nem létező rendszámot;
        - a requirePlateNumber visszatérési értéke PlateNumber legyen;
        - az Issuer a PlateNumberGenerator osztályt kérje meg, hogy gyártson számára egy új rendszámot,
        de csak akkor fogadja el, ha kiadott rendszámok között még nem létezik a legyártott rendszám;
        az Issuer addig próbálkozzon a PlateNumberGenerator-nál, ameddig nem kap olyan rendszámot, ami még nem létezik
*/