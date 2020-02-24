package Basics;

public class BasicCalculator {
    public static void main(String[] args) {
        Double operandOne, operandTwo, result;
        String operator;
        Boolean ok;

        result = 0.0;
        ok = Boolean.TRUE;
        operandOne = Double.parseDouble(args[0]);
        operandTwo = Double.parseDouble(args[2]);
        operator = args[1];

        switch( operator ){
            case "+": {result = operandOne + operandTwo; break; }
            case "-": {result = operandOne - operandTwo; break; }
            case "*": {result = operandOne * operandTwo; break; }
            case "/": {result = operandOne / operandTwo; break; }
            default: {System.out.println("Érvénytelen műveleti jel."); ok = Boolean.FALSE; }
        }
        if( ok ) {System.out.println("Eredmény:" + result.toString() ) ;}

        /*
        operator = System.console().readLine();
        System.out.println(operator);
        */
    }
}
