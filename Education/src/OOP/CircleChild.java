package OOP;

public class CircleChild extends Circle {

    public CircleChild(double r, double x, double y) {
        super(r,x,y);
    }

    public CircleChild() {
        super();
    }
    public static void main(String[] args) {
        CircleChild circle0 = new CircleChild();
        CircleChild circle1 = new CircleChild(10.0, 10.0, 10.0);
    }
}
