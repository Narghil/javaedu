package Basics;

public class RecursiveFactorial {

    public static void main(String[] args) {
        System.out.println(factorial(6.0));
        System.out.println(append("",3));
    }

    static double factorial(double x) {
        if (x == 1.0) {
            return 1.0;
        } else {
            return x * factorial(x - 1);
        }
    }

    static String append( String s, int i){
        final String CELL = "-";

        if( i == 0){
            return s;
        } else {
            return append( s+CELL, i-1);
        }
    }
}
