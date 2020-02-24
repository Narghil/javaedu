package Basics;

public class AverageCalculator {
    static double avg(int... grades) {
        Double retVal = 0.0;
        Integer numOfValues;

        numOfValues = grades.length;
        for (double d : grades) {
            retVal = retVal + d;
        }
        retVal = retVal / numOfValues;

        return retVal;
    }

    public static void main(String... args) {
        System.out.println(String.format("Az átlag: %.2f",avg(132, 465, 700)));
    }
}
