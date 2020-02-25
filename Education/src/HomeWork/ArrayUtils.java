package HomeWork;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {

    static String intArrayList( int[] numbers){
        String result = "";

        for( int i:numbers){
            result = result.concat(i+" ");
        }

        return result;
    }

    static int[] generateRandomNumbers(){
        int[] randomNumbers;
        Random random = new Random();

        randomNumbers = new int[10];
        for(int j = 0; j < 10; j++){
            randomNumbers[j] = random.nextInt(100);
        }

        return randomNumbers;
    }

    static int searchIndexFor( int[] array, int value ){
        Arrays.sort(array);
        return Arrays.binarySearch(array, value);
    }

    public static void main(String[] args) {
        int[] intArray, subArray;

        intArray = generateRandomNumbers();
        System.out.println("Rendezetlen tömb:"+ intArrayList(intArray));
        Arrays.sort(intArray);
        subArray = Arrays.copyOfRange( intArray, 0,3  );

        System.out.println("Rendezett tömb:"+ intArrayList(intArray));
        System.out.println("Résztömb (0.-3. elemek):"+intArrayList(subArray));

        for (int value : subArray) {
            System.out.println(value + ":" + (1 + searchIndexFor(intArray, value)) + ". elem");
        }
    }
}

/*
Ismerd meg az Arrays osztály sort, binarySearch és copyOfRange metódusait! (ArrayUtils.java)
a./ Írj metódust a következő szignatúrával: static int[] generateRandomNumbers(int length)
b./ Az a./-ban megírt metódussal generált tömb elemeit rendezd az Arrays.sort()-tal
c./ Írj egy metódust ezzel a szignatúrával: static int searchIndexFor(int[] array, int value)
// az átvett tömböt rendezze, majd keresse meg benne a második paraméterben átvett értéket a binarySearch() használatával
c./ Az Arrays.copyOfRange() metódusával hasíts ki subarray-t egy int[] tömbből. Ellenőrizd az eredményt index helyesség szerint!
 */
