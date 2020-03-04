package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import static PG.Utils.ScreenUtils.cls;

public class IterationFlavors {

    public static void main(String[] args) {
        List myData = testData();

        cls();
        System.out.println("FOREACH:");
        useForEach(myData);
        System.out.println();
        System.out.println("ITERATOR:");
        useIterator(myData);

    }

    private static List testData() {
        List result = new ArrayList();
        Random rnd = new Random();

        for (int i = 1; i <= 20; i++) {
            result.add(rnd.nextInt(90) + 1);
        }
        result.sort(null);
        return result;
    }

    private static void useForEach(List list) {
        for (Object o : list) {
            System.out.print(o.toString() + " ");
        }
        System.out.println();
    }

    private static void useIterator(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next().toString() + " ");
        }
        System.out.println();
    }
}
