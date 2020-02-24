package Basics;

public class Assertions {
    public static void main(String[] args) {
        int elvartErtek, szamoltErtek;

        elvartErtek = 1;
        szamoltErtek = 2;
        assert elvartErtek == szamoltErtek : "Nem egyező értékek";
        assert elvartErtek != szamoltErtek : "Egyező értékek";

    }
}
