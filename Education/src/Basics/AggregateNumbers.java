package Basics;

import java.util.Random;

public class AggregateNumbers {

    public static void main(String[] args) {
        Random random = new Random();
        int sum = 0;
        int steps = 0;

        int rangeMin = 1;
        int rangeMax = 10;

        do {
            // FONTOS: Random.nextInt() generates a random integer from 0 (inclusive) to bound (exclusive).
//            int randomInt = random.nextInt(10);
            int randomInt = random.nextInt(rangeMax - rangeMin + 1) + rangeMin;
            sum += randomInt;
            steps++;
            System.out.println("Added " + randomInt);
        } while (sum < 100);

        System.out.println("Sum: " + sum + ". (" + steps + " steps.)");
    }

}