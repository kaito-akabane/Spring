package ch03.use;

import ch03.used.AddCalc;
import ch03.used.SubCalc;
import ch03.used.Calculator;

public class Call {
    public static void main(String[] args) {
        Calculator calculator =  new AddCalc(); // new SubCalc();
        Integer result = calculator.calc(10, 5);
        System.out.printf("계산 결과는 %d입니다.", result);
    }
}