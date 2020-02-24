package Basics;

public class MultipleTable {
    public static String maskedNumber(Integer i, int length, String gap, String end) {
        String resultStr;
        resultStr = i.toString();
        while (resultStr.length() < 3) {
            resultStr = gap + resultStr;
        }
        resultStr = resultStr + end;
        return resultStr;
    }

    public static void main(String[] args) {
        System.out.print("    ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(maskedNumber(i, 4, " ", " "));
        }
        System.out.println("");
        System.out.println("-------------------------------------------");

        for (int i = 1; i <= 10; i++) {
            System.out.print(maskedNumber(i, 3, " ", ":"));
            for (int j = 1; j <= 10; j++) {
                System.out.print(maskedNumber(i * j, 4, " ", " "));
            }
            System.out.println("");
        }
    }
}
