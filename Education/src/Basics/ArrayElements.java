package Basics;

public class ArrayElements {
    public static void main(String[] args) {
        int i, sLen, pLen, maxLen;
        int salaries[] = /*new int[]*/{100, 200, 300, 400, 500};
        String[] persons = /*new String[]*/{"John", "Mary", "Joan"};

        sLen = salaries.length;
        pLen = persons.length;
        maxLen = (sLen < pLen) ? sLen : pLen;

        for (i = 0; i < 2; i++) {
            outLine(salaries[i], persons[i]);
        }
    }

    static void outLine(int salary, String person) {
        System.out.println(person + " fizetése (100Ft):" + salary);
    }
}