package DesignPatterns;

import java.util.*;

import static PG.Utils.ScreenUtils.cls;

public class PackDelivery {

    public static void main(String[] args) {
        List cityNames = Arrays.asList("Szeged", "Pecs", "Komarom", "Miskolc", "Debrecen", "Gyor");
        //Set cityes = new HashSet();
        City prevCity = null, actCity = null, firstCity = null;

        Pack pack1 = new Pack("A001", "Budapest");
        Pack pack2 = new Pack("A002", "Debrecen");
        Pack pack3 = new Pack("A003", "Komarom");

        Collections.shuffle(cityNames);
        prevCity = null;
        Iterator it = cityNames.iterator();
        while (it.hasNext()) {
            actCity = new City(it.next().toString(), prevCity);
            //cityes.add(actCity);
            prevCity = actCity;
        }
        cls();
        actCity.handle(pack1);
        System.out.println(pack1.getStamps());
        actCity.handle(pack2);
        System.out.println(pack2.getStamps());
        actCity.handle(pack3);
        System.out.println(pack3.getStamps());
    }
}

interface PackHandler {
    void handle(Pack pack);
    //Interface tartalmazhat konstanst!
    Integer inInt0 = 0;
    Integer inInt1 = 1;
}

class Pack {
    private String id;
    private String to;
    private List stamps = new ArrayList();

    public List getStamps() {
        return stamps;
    }
    public void addStamp(String stamp) {
        stamps.add(stamp + " ");
    }
    public String getTo() {
        return to;
    }
    //Constructor
    public Pack(String id, String to) {
        this.id = id;
        this.to = to;
    }
}

class City implements PackHandler {
    private City nextCity;
    private String name;

    public void handle(Pack pack) {
        pack.addStamp(this.name);
        if (pack.getTo() != this.name) {
            if (nextCity != null) {
                nextCity.handle(pack);
            } else {
                pack.addStamp(" ismeretlen cím");
                System.out.println(inInt0);
            }
        } else {
            pack.addStamp(" megérkezett.");
            System.out.println(inInt1);
        }
    }

    public City(String name, City nextCity) {
        this.name = name;
        this.nextCity = nextCity;
    }
}







