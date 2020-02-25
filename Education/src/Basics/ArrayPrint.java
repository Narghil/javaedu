//Ezt a file-t használom a GitHub tesztelésére is.
//- A GitHub-on lévő módosítás megjelent a lokális fileban.
//- A lokális módosítások megjelentek a GitHub-on is, Commit ÉS Push után.
package Basics;

public class ArrayPrint {

    public static void main(String[] args) {
        int[][] intArray = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};
        int[] element;

        for (int[] ints : intArray) {
            element = ints;
            for (int i : element) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
