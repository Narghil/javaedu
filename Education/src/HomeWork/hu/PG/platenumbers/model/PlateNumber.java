package HomeWork.hu.PG.platenumbers.model;

public class PlateNumber {
    private String letterPart;
    private String numberPart;
    public PlateNumber( String letterPart, String numberPart){
        this.letterPart = letterPart;
        this.numberPart = numberPart;
    }
    public String getFullPlateNumber(){
        return letterPart+"-"+numberPart;
    }
}

/*
hu.platenumbers.model.PlateNumber
 - konstruktora vegyen át 2 String-et, a rendszám betű és szám részeit;
 - a konstruktor az átvett paramétereket tárolja el az osztály ezen két adattagjában:
    String letterPart és String numberPart;
 - az osztálytól lehessen lekérdezni a teljes rendszámot, mondjuk a public String getFullPlateNumber() metódusban,
    ami összefűzi a rendszám 2 részét, köztük egy kötőjelet téve;
 */
