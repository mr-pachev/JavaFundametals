package Lab._04;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double inputNumber = Double.parseDouble(scanner.next());
        double inputPower = Double.parseDouble(scanner.next());

        double resultMathPower = mathPower(inputNumber, inputPower);

        DecimalFormat df = new DecimalFormat("0.####");
        System.out.println(df.format(resultMathPower));
    }

    public static double mathPower(double num, double power) {
        double result = 1;
        for (int i = 1; i <= power; i++) {
            result = result * num;
        }
        return result;
    }
}
