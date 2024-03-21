package ch03.use;

import ch03.used.Calculator;
import ch03.used.SubCalc;

public class Call {
    public static void main(String[] args) {
        Calculator calculator = new SubCalc();
        Integer result = calculator.calc(10, 5);
        System.out.println(STR."\{result}");
    }
}