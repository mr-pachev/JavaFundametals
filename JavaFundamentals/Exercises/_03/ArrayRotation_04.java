package Exercises._03;

import java.util.Scanner;

public class ArrayRotation_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");// четене масив тип String по разделител Space
        int n = Integer.parseInt(scanner.nextLine());// брой итераций

        for (int i = 1; i <= n; i++) {// цикъл според броя итераций
            String firstPosition = arr[0];

            for (int j = 0; j < arr.length - 1; j++) {// преместването на елементите от цикъла arr наляво, обхожзането е с едно по-малко то дължината на arr
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = firstPosition;
        }
        for (String current : arr) {
            System.out.print(current + " ");
        }
    }
}
