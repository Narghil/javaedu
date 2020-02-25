//Ezt a file-t használom a GitHub tesztelésére is.
package Basics;

public class ArrayPrint {

    public static void main(String[] args) {
        int[][] intArray = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};
        int[] element;

        for (int i = 0; i < intArray.length; i++) {
            element = intArray[i];
            for (int j = 0; j < element.length; j++) {
                System.out.print(element[j]+" ");
            }
            System.out.println("");
        }
    }
}
