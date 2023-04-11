package MoreExer_03;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array1 = scanner.nextLine().split(" "); //масив String от конзолата
        int[] numbers = new int[array1.length];

        for (int i = 0; i < array1.length; i++) {    //пълнене на масива от тип int
            numbers[i] = Integer.parseInt(array1[i]);
        }

        int maxLength = 0;                          //показва максимална дължина на нарастващата последователност
        int lastIndex = -1;
        int[] len = new int[numbers.length];       //ще съдържа най-дългата нарастваща последователност с дължина равна на основния масив
        int[] previous = new int[numbers.length];  //ще съдържа най-ЛЯВАТА нарастваща последователност с дължина равна на основния масив

        for (int i = 0; i < numbers.length; i++) {  //обхожда основния масив с числа
            len[i] = 1;
            previous[i] = -1;

            for (int k = 0; k < i; k++) {
                if (numbers[k] < numbers[i] && len[k] + 1 > len[i]) {
                    len[i] = len[k] + 1;
                    previous[i] = k;
                }
            }

            if (len[i] > maxLength) {
                maxLength = len[i];
                lastIndex = i;
            }
        }

        int[] lis = new int[maxLength];
        int currentIndex = maxLength - 1;

        while (lastIndex != -1) {
            lis[currentIndex] = numbers[lastIndex];
            currentIndex--;
            lastIndex = previous[lastIndex];
        }
        for (int print = 0; print < lis.length; print++) {
            System.out.print(lis[print] + " ");
        }
    }
}
