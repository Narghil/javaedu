package Generics;

import java.util.Arrays;

public class FindMatches {

    public static void main(String[] args) {
        Finder finder = new Finder();

        String[] stringArray = {"John", "Mary", "Joan"};
        Integer[] integerArray = {1, 3, 3, 4, 5, 6};

        System.out.println(Arrays.toString(stringArray)+"/Joan:" + finder.occurances( stringArray, "Joan"));
        System.out.println(Arrays.toString(integerArray)+"/3:"+ + finder.occurances(integerArray, 3));

    }
}

class Finder<T> {

    public int occurances(T[] arrayT, T anT) {

        int i = 0;
        for (T x : arrayT) {
            if (x.equals(anT)) {
                i++;
            }
        }

        return i;
    }
}