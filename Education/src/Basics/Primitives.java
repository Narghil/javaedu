package Basics;

public class Primitives {
    public static void main(String[] args) {
        Byte b = 0;
        Integer i = 0;
        Long l = 0l;
        Float f = 0.0f;
        Character c = ' ';

        System.out.println( "Byte range   :" + b.MIN_VALUE + " - " + b.MAX_VALUE );
        System.out.println( "Integer range:" + i.MIN_VALUE + " - " + i.MAX_VALUE );
        System.out.println( "Long range   :" + l.MIN_VALUE + " - " + l.MAX_VALUE );
        System.out.println( "Float range  :" + f.MIN_VALUE + " - " + f.MAX_VALUE );
        System.out.println( "Char range   :" + c.MIN_VALUE + " - " + c.MAX_VALUE );
    }
}
