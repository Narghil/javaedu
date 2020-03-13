package ExcerciseProjects;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static PG.Utils.ScreenUtils.cls;
import static PG.Utils.StringUtils.replicate;

public class SentenceIterator {

    public static void main(String[] args) {
        Seti aSeti = new Seti("The quick brown fox jumps over the lazy dog");
        cls();
        aSeti.printWords();
        aSeti.printWordsIter(0);
    }

}

class Seti {

    private List<String> lstWords = new LinkedList<String>();
    private String[] strWords;

    Seti(String line) {

        strWords = line.split(" ");
        for (int i = 0; i < strWords.length; i++) {
            lstWords.add(strWords[i]);
        }

    }

    public void printWords() {
        int idx = 0;

        System.out.println("Kiíratás List-tel és Iterator-ral.");
        Iterator it;
        it = lstWords.iterator();
        while (it.hasNext()) {
            System.out.print(replicate("" + (char) 9, idx));
            System.out.println((String) it.next());
            idx++;
        }

        System.out.println("Kiíratás tömbbel.");
        for (int i = 0; i < strWords.length; i++) {
            System.out.print(replicate("" + (char) 9, i));
            System.out.println(strWords[i]);
        }

    }

    public void printWordsIter(int idx) {
        if (idx == 0) {
            System.out.println("Kiíratás rekurzióval.");
        }
        if (idx >= strWords.length) {
            return;
        } else {
            System.out.print(replicate("" + (char) 9, idx));
            System.out.println(strWords[idx]);
            //idx++;
            printWordsIter(++idx);
            return;
        }

    }
}
