package Exercises._04;

import java.util.Scanner;

public class FactorialDivision_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        long factorielFirstNum = getFactoriel(firstNum);
        long factorielSecondNum = getFactoriel(secondNum);

        System.out.printf("%.2f", getDivision(factorielFirstNum, factorielSecondNum));

    }
    private static long getFactoriel(int num){
        long result = 1;
        for (int i = 1; i <= num ; i++) {
            result = result * i;
        }
        return result;
    }
    private static double getDivision(long one, long two){
        double result = one * 1.0/ two;
        return result;
    }
}
