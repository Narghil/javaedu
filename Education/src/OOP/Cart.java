package OOP;

public class Cart {
    String[] goods = new String[10];
    Integer[] quantities = new Integer[10];
    Double[] prices = new Double[10];
    Integer size;

    public void addToCart( String nameOfGood, Integer quantity, Double price){
        System.out.println(nameOfGood+" added");
    }

    public double getTotal(){
        return 0.0;
    }

    public double getDiscount(){
        return 0.0;
    }

    public Cart(){
        size = 0;
    }

    public static void main(String[] args) {
        Cart webCart = new Cart();

        webCart.addToCart("Macskakaja",0,0d);
    }
}

