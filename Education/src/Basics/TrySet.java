package Basics;

import java.util.HashSet;
import java.util.Set;

public class TrySet {
    public static void main(String[] args) {
        Set myNumbers = new HashSet();
        Byte b = 20;
        Short s = 20;
        Integer i = 20;

        myNumbers.add(s);
        myNumbers.add(i);
        myNumbers.add(b);

        System.out.println(myNumbers);
    }
}
