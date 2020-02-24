package Basics;

public class CommandLineArguments {
    public static void main(String[] args) {
        System.out.println("Kapott paraméterek száma:"+args.length);

        for (String s: args ) {
            System.out.println( s );
        }
    }
}
