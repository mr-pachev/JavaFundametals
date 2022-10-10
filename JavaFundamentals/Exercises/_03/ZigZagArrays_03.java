package Exercises._03;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] firstRow = new int[n];
        int[] secondRow = new int[n];

        for (int i = 1; i <= n; i++) {
            String current = scanner.nextLine();
            int firstNum = Integer.parseInt((current.split(" "))[0]);
            int secondNum = Integer.parseInt((current.split(" "))[1]);

            if (i % 2 == 0) {
                firstRow[i - 1] = secondNum;
                secondRow[i - 1] = firstNum;
            } else {
                firstRow[i - 1] = firstNum;
                secondRow[i - 1] = secondNum;
            }
        }
        for (int number : firstRow) {
            System.out.print(number + " ");
        }
        System.out.println();
        for (int number : secondRow) {
            System.out.print(number + " ");
        }
    }
}
