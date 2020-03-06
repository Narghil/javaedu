package OOP;

import static PG.Utils.ScreenUtils.cls;
import static PG.Utils.StringUtils.replicate;

//Csak indokolt esetben (adatelrejtés) van értelme class-on belül létrehozni.
enum CoffeeItems {
    DEMI(3, 6d, "Jelentése:'Fél'. 89 ml."),
    SHORT(8, 16d, "Jelentése:'Rövid'. 240 ml. Az eredeti Starbucks méret."),
    TALL(12, 24d, "Jelentése:'Magas'. 350 ml. Eredetileg 'Kicsi' volt a neve; ha 'kis' kávét kérsz, ezt hozzák ki."),
    GRANDE(16, 32d, "Jelentése:'Nagy'. 470 ml."),
    VENTI(20, 40d, "Jelentés: 'Húsz'. 590 ml. Pont húsz uncia."),
    TRENTA(31, 60d, "Jelentése:'Szomjas'. 920 ml. Csak jeges italok kérhetők ilyen méretben.");

    private int size;
    private double price;
    private String remark;

    CoffeeItems(int s, double p, String r) {
        this.size = s;
        this.price = p;
        this.remark = r;
    }

    public String toString() {
        return this.name() + " (" + this.size + " oz), price:" + this.price;
    }

    public String getRemark(){ return this.remark;}

}

public class StarbucksCoffee {


    public static void main(String[] args) {
        CoffeeItems[] menu = CoffeeItems.values();

        cls();
        for (CoffeeItems cs : menu) {
            System.out.println(cs.toString());
            System.out.println(cs.getRemark());
            System.out.println(replicate("-",100));
        }
        
    }

}
