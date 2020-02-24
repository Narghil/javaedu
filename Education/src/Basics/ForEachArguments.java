package Basics;

public class ForEachArguments {
    public static void main(String[] args) {
        System.out.println("Kapott paraméterek száma:"+args.length);

        System.out.print("ForEach ciklus:");
        for (String s: args ) {
            System.out.print( s+" " );
        }

        System.out.println("");

        System.out.print("For ciklus:");
        for (int i =0; i < args.length; i++)
            System.out.print(args[i]+" ")
        ;
    }
}
