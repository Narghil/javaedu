package Collections;

//import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DeleteElements {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList();  //Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9); - Returns a fixed-size list backed by the specified array.
                                            //Create a LinkedList, which supports faster remove.: new LinkedList<String>(Arrays.asList(split));

        for( int x =1; x<10; x++){l.add(x);}
        System.out.println(l.toString());

        for (Integer i:l ){
        //for (int i = 0; i < l.size(); i++) {
            //System.out.print(l.size() + " => ");
            if (i == 7) {
                System.out.println("Remove:"+i);
                //System.out.println("DELETING");
                l.remove(i);
                //System.out.println("DELETED");
                System.out.println("New size:"+l.size());
            }
            //System.out.println(l.size() );
        }
        System.out.println(l.toString());
/*
        Iterator<Integer> it = l.iterator();
        while (it.hasNext()) {
            Integer current = it.next();
            if (current == 5) {
                it.remove();
                System.out.println("New size:" + l.size());
            }
        }
*/
        System.out.println(l.toString());
    }
}
