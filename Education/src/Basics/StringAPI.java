package Basics;

import java.util.Arrays;

public class StringAPI {
    public static void main(String[] args) {
        /*
        if (containsByte("ABCD", (byte) 65)) {
            System.out.println("Benne van");
        } else {
            System.out.println("Nincs benne");
        }
        */
        //System.out.println(Arrays.asList(collectNumbers("dog,cat,friendship,20,twenty")));
        System.out.println(Arrays.asList(
                retrieveWordsStartingWith(0, "One", "Two", "Three", "eight")
        ));

    }

    static String[] retrieveWordsStartingWith(int type, String... elements) {
        //System.out.println(Arrays.asList(elements));

        String[] output = new String[elements.length];
        String pattern = "";
        int i = 0;

        switch (type) {
            case 0: {
                pattern = "[euioaEUIOA].*";
                break;
            }
            case 1: {
                pattern = "[^euioaEUIOA].*";
                break;
            }
            default: {
                System.out.println("Illegal first parameter");
                return null;
            }
        }
        for (String element : elements) {
            if (element.matches(pattern)) {
                output[i++] = element;
            }
         }
        String[] returnPut = new String[i--];
        for (int j = 0; j <= i; j++) {
            returnPut[j] = output[j];
        }

        return returnPut; //new String[1];
    }

    static boolean containsByte(String input, byte search) {
        for (byte b : input.getBytes()) {
            if (b == search) return true;
        }
        return false;
    }

    static String[] collectNumbers(String inputStr) {
        String[] splitted = inputStr.split(",");
        String[] output = new String[splitted.length];
        int i;

        i = 0;
        for (String split : splitted) {
            try {
                Integer.parseInt(split);
                output[i++] = split;
            } catch (Exception nfex) {
            }
        }

        String[] returnPut = new String[i--];
        for (int j = 0; j <= i; j++) {
            returnPut[j] = output[j];
        }

        return returnPut;
    }


}
