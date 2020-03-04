package Collections;
//import PG.Utils.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static PG.Utils.ScreenUtils.cls;
import static java.lang.Math.pow;

class Power implements Comparable{
    private Integer base, exp;
    public Integer getBase() {
        return base;
    }

    public Integer getExp() {
        return exp;
    }

    private Power(){}
    public Power( int base, int exp){
        this.base = base;
        this.exp = exp;
    }
    @Override
    public String toString() {
        return this.base+"^"+this.exp;
    }
    public int compareTo(Object o) {
        Power p = (Power) (o);
        int baseDiff = (this.getBase().compareTo(p.getBase()));
        int expDiff  =  (this.getExp().compareTo(p.getExp()));
        return baseDiff == 0 ? expDiff : baseDiff;
    }
}

public class MapAdventures {

    public static void main(String[] args) {
        cls();

        Map twoPowers = new HashMap();

        for (int i = 0; i <= 10; i++) {
            twoPowers.put(new Power(2,i ), pow(2 , i) );
        }
        System.out.println("Map :" + twoPowers);

        Map twoPowersTree = new TreeMap();

        for (int i = 0; i <= 10; i++) {
            twoPowersTree.put(new Power(2,i ), pow(2 , i));
        }

        System.out.println("Tree:" + twoPowersTree);

    }
}
