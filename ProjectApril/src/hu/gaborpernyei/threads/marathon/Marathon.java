package hu.gaborpernyei.threads.marathon;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Marathon {
    public static void main(String[] args) {
        //Ez azért kell, mert a notify()/notifyAll() nem adható ki statikus metódusból-ból.
        Marathon marathon = new Marathon();
        marathon.doIt();
    }

    LongDistanceRunner[] runners = new LongDistanceRunner[5];
    Thread[] threads = new Thread[5];
    Random rnd = new Random();

    public void doIt() {
        for (int i = 0; i < 5; i++) {
            runners[i] = new LongDistanceRunner("Futó_" + (i+1), 8.0 + rnd.nextFloat() * 18); //Sebesség 8 és 26 között legyen.
            threads[i] = new Thread(runners[i]);
            threads[i].start();
        }
        //3 másodperc késleltetés...
        try {
            sleep( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        //Startjel kiadása...
        for (int i = 0; i < 5; i++) {
            runners[i].setBoolRaceStarted( true );
        }
        //A notifyAll()/notify()) csak synchronised objektumra adható ki, különben: IllegalMonitorException -t dob!
        //Konkrétan arra az objektumra kell kiadni a notyfy()/notifyAll()-t, amelyiket fel akarjuk ébreszteni.
        //A notifyAll() -nak akkor van értelme, ha ugyanannak az objektumnak több szála is várakozik.
        //ld: https://www.geeksforgeeks.org/difference-notify-notifyall-java/
        for (int i = 0; i < 5; i++) {
            synchronized (runners[i]) {
                runners[i].notify();
            }
        }
        System.out.println("A verseny elindult.");
    }
}

class LongDistanceRunner implements Runnable{
    private String strName = "Anonymus";
    private Double dblSpeed = 0d;
    private final Double dblWholeDistance = 42.195d;  //A teljes táv
    private Double dblDistanceYet = dblWholeDistance; //Ennyit kell még lefutnia
    private Boolean boolRaceStarted = false;
    private final long timeStep = 1000;     //Másodpercenkénti aktivitás...
    private final long timeMultiplier = 10; //1 másodperc valós idő a programban ennyi perc a futásban. A feladatleírás 1-et mond, én 10-et vettem, hogy ne őszüljek meg a végéig.
    private Double unitDistance;            //1p alatt ennyit halad a futó.

    public LongDistanceRunner( String name, double kmPerH ){
        this.strName = name; this.dblSpeed = kmPerH;
        this.unitDistance = (kmPerH / 60.0d) * timeMultiplier;
    }

    public void setBoolRaceStarted(Boolean started){
        this.boolRaceStarted = started;
    }

    @Override
    public void run() {
        System.out.println(strName + " a startra vár...");
        //A while valójában fölösleges, de ha több minden okból kiadásra kerülne a notify(), akkor vizsgálni kellene,
        // hogy a számunkra megfelelő változás megtörtént-e
        while( ! boolRaceStarted ) {
            //A wait() csak synchronised objektumra adható ki, különben: IllegalMonitorException -t dob!
            synchronized ( this ) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        while( dblDistanceYet > 0 ){
            try {
                sleep( timeStep );
                //Csökkentjük a hátralévő távolságot
                this.dblDistanceYet -= this.unitDistance;
                //Kiírjuk a megtett utat.
                System.out.printf(this.strName + " %6.3f km-t tett meg.%n",(this.dblWholeDistance - this.dblDistanceYet) );
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        System.out.println(strName+" CÉLBA ÉRT!");
    }
}