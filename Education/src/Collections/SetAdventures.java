package Collections;

import java.util.HashSet;
import java.util.Set;

public class SetAdventures {
    private Set oddNumbers = new HashSet();
    private Set allNumbers = new HashSet();

    public SetAdventures() {
        for (int i = 1; i <= 10; i = i + 2) {
            oddNumbers.add(i);
        }

        for (int i = 1; i <= 10; i++) {
            allNumbers.add(i);
        }
    }

    public static void main(String[] args) {
        SetAdventures s = new SetAdventures();

        //cls;
        System.out.println("All numbers:" + s.allNumbers);
        System.out.println("Odd numbers:" + s.oddNumbers);
        s.allNumbers.retainAll(s.oddNumbers);
        System.out.println("Intersect  :" + s.allNumbers);
        s = new SetAdventures();
        s.allNumbers.removeAll(s.oddNumbers);
        System.out.println("Even numbs.:" + s.allNumbers);
    }

}
