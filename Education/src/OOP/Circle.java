package OOP;

public class Circle {
    private Double radius;
    private Double x;
    private Double y;
    private boolean visible;

    public void setXY( Double xx, Double yy ){
        this.x = xx; this.y = yy;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Circle(Double r, Double x, Double y){
        this.setRadius( r )   ;
        this.setXY( x, y );
    }

    public Double getArea(){
        return 0d;
    }

    public Double getPerimeter(){
        return 0d;
    }

    public Double getRadius() {
        return radius;
    }

    public static void main(String[] args) {
        Circle c = new Circle(0d,0d,0d);
    }

    public boolean isVisible() {
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
