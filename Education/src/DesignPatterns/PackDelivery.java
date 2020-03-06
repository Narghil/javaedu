package DesignPatterns;

import java.util.*;

import static PG.Utils.ScreenUtils.cls;

public class PackDelivery {

    public static void main(String[] args) {
        List cityNames = Arrays.asList("Szeged", "Pecs", "Komarom", "Miskolc", "Debrecen", "Gyor");
        Set cityes = new HashSet();
        City prevCity = null, actCity = null, firstCity = null;
        Pack pack = new Pack("A001", "Budapest");

        Collections.shuffle(cityNames);
        Iterator it = cityNames.iterator();
        while (it.hasNext()) {
            actCity = new City(it.next().toString());
            cityes.add(actCity);
            if (prevCity != null) {
                prevCity.setNextCity(actCity);
            } else {
                firstCity = actCity;
            }
            prevCity = actCity;
        }
        firstCity.handle(pack);
        cls();
        System.out.println(pack.getStamps());

    }
}

interface PackHandler {
    void handle(Pack pack);
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

    public void setNextCity(City nextCity) {
        this.nextCity = nextCity;
    }
    public void handle(Pack pack) {
        pack.addStamp(this.name);
        if (pack.getTo() != this.name) {
            if (nextCity != null) {
                nextCity.handle(pack);
            } else {
                pack.addStamp(" ismeretlen cím");
            }
        } else {
            pack.addStamp(" megérkezett.");
        }
    }

    public City(String name) {
        this.name = name;
        this.nextCity = null;
    }
}







