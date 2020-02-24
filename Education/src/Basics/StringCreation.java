package Basics;

public class StringCreation {
    public static void main(String[] args) {
        String s1 = new String( "Original");
        String s2 = new String( new byte[]{65,66,67} );
        String s3 = new String( new char[]{'a','b','c'});

        System.out.println(s1+','+s2+','+s3);
    }
}
