package gcf;

public class GooseCornFox {
    private BankOfTheRiver kozeliPart;
    private BankOfTheRiver tavoliPart;
    private BankOfTheRiver aktualisPart;

    public BankOfTheRiver getKozeliPart(){
        return kozeliPart;
    }

    public static void main(String[] args) throws GCFException {
        GooseCornFox gcf = new GooseCornFox();

        //Játszunk!
        gcf.moveActor( Goose.getInstance() );
        gcf.moveActor(null);
        gcf.moveActor( Fox.getInstance() );
        gcf.moveActor(null);

    }

    //Constructor
    public GooseCornFox() {
        kozeliPart = new BankOfTheRiver("Közeli part");
        tavoliPart = new BankOfTheRiver("Távoli part");

        kozeliPart.setFarmer(Farmer.getInstance());
        kozeliPart.setGoose(Goose.getInstance());
        kozeliPart.setFox(Fox.getInstance());
        kozeliPart.setCorn(Corn.getInstance());
        aktualisPart = kozeliPart;

        System.out.println(kozeliPart);
        System.out.println(tavoliPart);
    }

    public void moveActor(Actor actor) throws GCFException {
        BankOfTheRiver masikPart = (aktualisPart == kozeliPart ? tavoliPart : kozeliPart);

        if (aktualisPart.getFarmer() != null) {
            //Ez hibás! Akkor is átviszi a farmert, ha olyan actort adunk meg, aki ott sincs a parton!
            masikPart.setFarmer( aktualisPart.getFarmer());
            aktualisPart.setFarmer(null);

            //Corn
            if( actor instanceof Corn ){
                if( aktualisPart.getCorn() != null){
                    masikPart.setCorn( aktualisPart.getCorn());
                    aktualisPart.setCorn(null);
                }
            }
            if( actor instanceof Fox ){
                if( aktualisPart.getFox() != null){
                    masikPart.setFox( aktualisPart.getFox());
                    aktualisPart.setFox(null);
                }
            }
            if( actor instanceof Goose ){
                if( aktualisPart.getGoose() != null){
                    masikPart.setGoose( aktualisPart.getGoose());
                    aktualisPart.setGoose(null);
                }
            }

            System.out.println("-----------------------------------------");
            System.out.println(kozeliPart);
            System.out.println(tavoliPart);
            //System.out.println(aktualisPart);
            kozeliPart.checkDanger();
            tavoliPart.checkDanger();

            aktualisPart = masikPart; //!!! -- az aktuális part mindig az kell legyen, ahol a farmer van!
        }

    }
}

//Használatba veszünk egy marker interface-t
interface Actor {
}

class Farmer implements Actor {
    @Override
    public String toString() {
        return " farmer";
    }

    //Making Singleton
    private static Farmer singleton;
    public static Farmer getInstance(){
        if( singleton==null){
            singleton = new Farmer();
        }
        return singleton;
    }
    private Farmer(){}
}

class Goose implements Actor {
    @Override
    public String toString() {
        return " liba";
    }

    //Making Singleton
    private static Goose singleton;
    public static Goose getInstance(){
        if( singleton==null){
            singleton = new Goose();
        }
        return singleton;
    }
    private Goose(){}

}

class Fox implements Actor {
    @Override
    public String toString() {
        return " róka";
    }

    //Making Singleton
    private static Fox singleton;
    public static Fox getInstance(){
        if( singleton==null){
            singleton = new Fox();
        }
        return singleton;
    }
    private Fox(){}

}

class Corn implements Actor {
    @Override
    public String toString() {
        return " kukorica";
    }

    //Making Singleton
    private static Corn singleton;
    public static Corn getInstance(){
        if( singleton==null){
            singleton = new Corn();
        }
        return singleton;
    }
    private Corn(){}

}

class BankOfTheRiver {
    //Alapból NULL az adattagok értéke.
    private Farmer farmer;
    private Corn corn;
    private Goose goose;
    private Fox fox;
    private String name;

    public BankOfTheRiver(String name) {
        this.name = name;
    }

    void checkDanger() throws GCFException {
        if (farmer == null) {
            if (fox != null && goose != null) {
                throw new GCFException(name+">> A róka megeszi a libát!");
            } else if (goose != null && corn != null) {
                throw new GCFException(name+">> A liba megeszi a kukoricát!");
            }
        }
    }

    @Override
    public String toString() {
        String sFarmer = farmer != null ? farmer.toString() : "";
        String sFox = fox != null ? fox.toString() : "";
        String sGoose = goose != null ? goose.toString() : "";
        String sCorn = corn != null ? corn.toString() : "";

        return this.name + ":" + sFarmer + sFox + sGoose + sCorn;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public Corn getCorn() {
        return corn;
    }

    public Goose getGoose() {
        return goose;
    }

    public Fox getFox() {
        return fox;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public void setCorn(Corn corn) {
        this.corn = corn;
    }

    public void setGoose(Goose goose) {
        this.goose = goose;
    }

    public void setFox(Fox fox) {
        this.fox = fox;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

class GCFException extends Exception {
    public GCFException(String errorMessage) {
        super(errorMessage);
    }
}