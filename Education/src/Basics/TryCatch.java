package Basics;

public class TryCatch {

    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        int c;

        try{
            c = a / a;
        } catch( Exception e){
            System.out.println("hiba");
        } finally {
            System.out.println("finally");
        }
        System.out.println("OK");
    }

}
