package Exercises._03;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int length = 1; // брояч за повтараемостта на даден елемент
        int maxLength = 0; // най-дългата повтараемост
        int leftLength = 0;


        for (int index = 1; index <= arr.length-1; index++) { // обхождане на масива arr
            int cuurentElement = arr[index]; // текущ елемент
            int compareElement = arr[index - 1]; // елемент с който се сравнява текущия елемент

            if (cuurentElement == compareElement) { // сравняване на текущия елемент с предходния
                length++;
            } else {
                length = 1;
            }

            if (length>maxLength) { // определявне макс дължина повтараемост на текущия елемент
                maxLength = length;
                leftLength = index; // определяне първия най- много повтарящ се елемент от масива
            }
        }

        for (int starrtIndex = leftLength; starrtIndex <= leftLength + maxLength-1 ; starrtIndex++) { // цикъл за принтиране броя пъти на максималния брой повтарящи се елементи
            System.out.print(arr[leftLength] + " ");
        }
    }
}
