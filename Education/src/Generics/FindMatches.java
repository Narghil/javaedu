package Generics;

import java.util.Arrays;

public class FindMatches {

    public static void main(String[] args) {
        Finder finder = new Finder();

        String[] stringArray = {"John", "Mary", "Joan"};
        Integer[] integerArray = {1, 3, 3, 4, 5, 6};

        System.out.println(Arrays.toString(stringArray)+"/Joan:" + finder.occurances( stringArray, "Joan"));
        System.out.println(Arrays.toString(integerArray)+"/3:"+ + finder.occurances(integerArray, 3));

        Excer1 e1 = new Excer1();
        e1.doSomeThing();

        Excer2 e2 = new Excer2();
        e2.doSomeThing();

    }
}

class Finder<T> {

    public int occurances(T[] arrayT, T anT) {

        int i = 0;
        for (T x : arrayT) {
            if (x.equals(anT)) {
                i++;
            }
        }

        return i;
    }

}

interface Excersizeable{
    void doSomeThing();
    //void doOtherThing();
    Integer aVariable = 11;

    class kinkyClass{
        private Integer bVar;
        protected void printSomeThing(){
            bVar = aVariable;
            System.out.println("Kinky Class Says:"+bVar+1);
        }
    }

}

class Excer1 implements Excersizeable {
    public void doSomeThing(){
        Excersizeable.kinkyClass kc = new Excersizeable.kinkyClass();
        kc.printSomeThing();
    }
}

class Excer2 extends Excer1{

}

