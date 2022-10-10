package Exercises._04;

import java.util.Scanner;

public class AddAndSubtract_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwoo = Integer.parseInt(scanner.nextLine());
        int numTree = Integer.parseInt(scanner.nextLine());

        int result = getCollection(numOne, numTwoo);

        System.out.println(getSubtract(result, numTree));

    }

    private static int getCollection(int num1, int num2) {
        int count = num1 + num2;
        return count;
    }

    private static int getSubtract(int num1, int num3) {
        int count = num1 - num3;
        return count;
    }
}
