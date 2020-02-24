package Basics;

public class Overflow {
    public static void main(String[] args) {
        int i = 0;

        i = Integer.MAX_VALUE +1;
        System.out.println(i);
        System.out.println((long)i);
        System.out.println((long)(Integer.MAX_VALUE+1));
        System.out.println((long)(Integer.MAX_VALUE)+1);
    }
}
