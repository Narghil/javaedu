package OOP;//Gyakorlás a setekkel; comparator

import java.util.*;

public class MeetComparator {

    public static List makeTestData() {

        List data = new ArrayList();

        data.add(new Player("Pele", 33, 160, 12, 23, 1.2, "Csető SC."));
        data.add(new Player("Nyilasi Tibor", 28, 168, 15, 32, 4.1, "Fradi"));
        data.add(new Player("Messi", 22, 172, 1, 3, 2.1, "Leon SC"));
        data.add(new Player("Puskás", 24, 162, 123, 31, 20.1, "Újpest"));
        data.add(new Player("Grosics", 34, 182, 103, 38, 20.5, "Hungarian Heroes"));
        data.add(new Player("Ábrahám", 12, 155, 3, 3, 0.1, "Hungarian Youngs"));

        //a((byte) 1, ""); //SORT-ost hív!
        //a( 1, ""); //INT-est hív!

        return data;
    }

    public static void printTestData(List data) {
        for (Object d : data) {
            System.out.println(d.toString());
        }
    }

    /*
        public static void a(int i, String s) {
            System.out.println("INT");
        }

        public static void a(short i, String s) {
            System.out.println("SORT");
        }
    */
    public static void main(String[] args) {
        List testData = makeTestData();

        //Collections.sort(testData);
        Collections.sort(testData, new compareByHeight());
        printTestData(testData);
    }
}

class compareByHeight implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Player p1 = (Player) o1;
        Player p2 = (Player) o2;
        return Integer.valueOf(p1.getHeight()).compareTo(p2.getHeight());
    }
}

class Player implements Comparable {

    private String name;
    private int age;
    private int height;
    private int goals;
    private int goalPasses;
    private double value;
    private String team;

    public Player(String name, int age, int height, int goals, int goalPasses, double value, String team) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.goals = goals;
        this.goalPasses = goalPasses;
        this.value = value;
        this.team = team;
    }

    public int compareTo(Object o) {
        Player p = (Player) (o);
        return this.name.compareTo(p.getName());
    }

    @Override
    public String toString() {
        return name + " (" + height + ") :" + value + " MEu.";
    }

    //Getters and Setters
    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public int getGoals() {
        return goals;
    }

    public int getGoalPasses() {
        return goalPasses;
    }

    public double getValue() {
        return value;
    }

    public String getTeam() {
        return team;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setGoalPasses(int goalPasses) {
        this.goalPasses = goalPasses;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setTeam(String team) {
        this.team = team;
    }


}


