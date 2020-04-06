package hu.gaborpernyei.threads.marathon;

import java.util.Random;
import static java.lang.Thread.sleep;

//A wait(), sleep(), notify(), notifyAll() hívásokat kiszerveztem egy külön interface-be.
interface WaitingAble {
    default boolean doWait( Runnable r ){
        //A wait() csak synchronised objektumra adható ki, különben: IllegalMonitorException -t dob!
        synchronized( r ){
            try{
                r.wait();
            } catch( InterruptedException e){
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    default boolean doSleep( Long millis){
        try {
            sleep( millis );
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //A notifyAll()/notify()) csak synchronised objektumra adható ki, különben: IllegalMonitorException -t dob!
    //Konkrétan arra az objektumra kell kiadni a notyfy()/notifyAll()-t, amelyiket fel akarjuk ébreszteni.
    //A notifyAll() -nak akkor van értelme, ha ugyanannak az objektumnak több szála is várakozik.
    //ld: https://www.geeksforgeeks.org/difference-notify-notifyall-java/
    default void doNotify( Runnable r){
        synchronized (r ) {
            r.notify();
        }
    }
    default void doNotifyAll( Runnable r){
        synchronized (r ) {
            r.notifyAll();
        }
    }
}

public class Marathon implements Runnable, WaitingAble {
    public static void main(String[] args) {
        //Ez azért kell, mert a notify()/notifyAll() nem adható ki statikus metódusból-ból.
        //marathon.doIt();
        Marathon marathon = new Marathon();
        Thread mainThread = new Thread(marathon);
        mainThread.start();
    }

    LongDistanceRunner[] ldrRunners = new LongDistanceRunner[5];
    Thread[] threads = new Thread[5];
    Random rnd = new Random();
    private Boolean boolRaceEnded = false; //Befejeződött-e a verseny?

    //public void doIt() {
    public void run(){
        for (int i = 0; i < 5; i++) {
            ldrRunners[i] = new LongDistanceRunner(this, "Futó_" + (i+1), 8.0 + rnd.nextFloat() * 18); //Sebesség 8 és 26 között legyen.
            threads[i] = new Thread(ldrRunners[i]);
            threads[i].start();
        }
        //3 másodperc késleltetés...
        if( ! doSleep( (long)3000 ) ){
            return;
        }
        ;
        //Startjel kiadása...
        for (LongDistanceRunner ldr: ldrRunners) {
            ldr.setBoolRaceStarted( true );
        }
        for (LongDistanceRunner ldr: ldrRunners) {
            doNotifyAll(ldr);
        }
        System.out.println("A verseny elindult.");

        //Ez nem volt a kiírásban, de így talán elegánsabb.
        //Értesítést kapunk, ha egy futó célba ért. Ha mind célba ért, a versenynek vége
        while( ! boolRaceEnded ) {
            doWait(this);
            boolRaceEnded = true;
            for (LongDistanceRunner ldr : ldrRunners) {
                synchronized( ldr ) {
                    boolRaceEnded = boolRaceEnded && (ldr.getDblDistanceYet() <= 0.0d);
                }
            }
        }
        System.out.println("A verseny befejeződött.");
    }
}

class LongDistanceRunner implements Runnable, WaitingAble{
    private String strName = "Anonymus";
    private Double dblSpeed = 0d;
    private final Double dblWholeDistance = 42.195d;  //A teljes táv
    private Double dblDistanceYet = dblWholeDistance; //Ennyit kell még lefutnia
    private Boolean boolRaceStarted = false;
    private final long lngTimeStep = 1000;     //Másodpercenkénti aktivitás...
    private final long lngTimeMultiplier = 30; //1 másodperc valós idő a programban ennyi perc a futásban. A feladatleírás 1-et mond, én ennyit vettem, hogy ne őszüljek meg a végéig.
    private Double dblUnitDistance;            //1p alatt ennyit halad a futó.
    private Marathon race;                  //Ezen a versenyen fut a futó.

    public LongDistanceRunner( Marathon race, String name, double kmPerH ){
        this.race = race;
        this.strName = name; this.dblSpeed = kmPerH;
        this.dblUnitDistance = (kmPerH / 60.0d) * lngTimeMultiplier;
    }

    public void setBoolRaceStarted(Boolean started){
        this.boolRaceStarted = started;
    }

    public Double getDblDistanceYet() {
        return dblDistanceYet;
    }

    @Override
    public void run() {
        System.out.println(strName + " a startra vár...");
        //A while valójában fölösleges, de ha több minden okból kiadásra kerülne a notify(), akkor vizsgálni kellene,
        // hogy a számunkra megfelelő változás megtörtént-e
        while( ! boolRaceStarted ) {
            if(! doWait( this )){
                return;
            }
        }
        while( dblDistanceYet > 0 ){
            try {
                sleep(lngTimeStep);
                //Csökkentjük a hátralévő távolságot
                this.dblDistanceYet -= this.dblUnitDistance;
                //Kiírjuk a megtett utat.
                System.out.printf(this.strName + " %6.3f km-t tett meg.%n",(this.dblWholeDistance - this.dblDistanceYet) );
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        System.out.println(strName+" CÉLBA ÉRT!");
        //Értesítjük a versenyt, mert a futó célba ért.
        doNotify( race );
    }
}
