package Basics;

public class CharacterRange {
    public static void main(String[] args) {
        Character c = ' ';

        System.out.println( "Char range as char     :" + c.MIN_VALUE + " - " + c.MAX_VALUE );
        System.out.println( "Char range as integer  :" + (int)c.MIN_VALUE + " - " + (int)c.MAX_VALUE );
        System.out.println( "Char range as long     :" + (long)c.MIN_VALUE + " - " + (long)c.MAX_VALUE );
    }
}

