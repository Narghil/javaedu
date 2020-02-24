package Basics;

public class StringEquality {
    public static void main(String[] args) {
        String s1 = "kutya";
        String s2 = new String( new byte[] {107,117,116,121,97});

        s2 = s1;
        s1 = "macska";
        System.out.println(s1+" ? "+s2);

        //assert s1 == s2 : "referencia szerint nem egyenlő";
        //assert s1 != s2 : "referencia szerint egyenlő";

        assert s1.equals(s2) : "Állapot szerint nem egyenlő";
        assert ! s1.equals(s2) : "Állapot szerint egyenlő";
    }
}
