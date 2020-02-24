package OOP;

public class CircleChild extends Circle {

    //SUPER: Az ős konstruktorának hívása, legalábbis itt
    //Az ős megfelelő metódust hívja
    public CircleChild() {
        super();
    }
    public CircleChild(double r, double x, double y) {
        super(r,x,y);
    }

    public static void main(String[] args) {
        CircleChild circle0 = new CircleChild();
        CircleChild circle1 = new CircleChild(10.0, 10.0, 10.0);
    }
}
