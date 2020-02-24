package Basics;

public class DisplayHex {
    public static void main(String[] args) {
        displayHex( 16356 );
    }

    static void displayHex( int input ){
        System.out.println( Integer.toHexString(input));
        System.out.println( Integer.toBinaryString(input));
        System.out.println( Integer.toOctalString(input));
    }
}
