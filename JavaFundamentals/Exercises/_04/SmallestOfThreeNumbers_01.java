package Exercises._04;

import java.util.Scanner;

public class SmallestOfThreeNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numb1 = Integer.parseInt(scanner.nextLine());
        int numb2 = Integer.parseInt(scanner.nextLine());
        int numb3 = Integer.parseInt(scanner.nextLine());

        comparesNumbers(numb1, numb2, numb3);

    }

    private static void comparesNumbers(int firstNum, int secondNum, int thirdNun) {
        if (firstNum <= secondNum && firstNum <= thirdNun) {
            System.out.println(firstNum);
        } else if (secondNum <= firstNum && secondNum <= thirdNun) {
            System.out.println(secondNum);
        } else if (thirdNun <= firstNum && thirdNun <= secondNum) {
            System.out.println(thirdNun);
        }
    }
}
