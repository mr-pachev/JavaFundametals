package MoreExer_03;

import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int bestSequenceSum = 0;                //най-голямата сума от последователности
        int bestSequenceIndex = 0;              //най-левия индекс на най-дългата последователност
        int count = 0;                          //брояч на позицийте
        int sequenceIndex = length;
        int[] dnaSequence = new int[length];    //масив с най-добрата последователност

        while (!input.equals("Clone them!")) {
            int[] arr = Arrays.stream(input.split("!+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int sum = 0;                    //сума от елементите на конкретния масив
            int index = length;             //стартиращия индекс на конкретната последователност
            count++;

            for (int i = 0; i < arr.length; i++) {
                if ((i != arr.length - 1) && arr[i] == 1 && arr[i + 1] == 1 && index == length) { //записва първия индекс на конкретната последователност
                    index = i;
                }
                sum += arr[i];
            }

            if (index == sequenceIndex && sum > bestSequenceSum) {
                dnaSequence = arr;
                bestSequenceIndex = count;
                bestSequenceSum = sum;
                sequenceIndex = index;

            } else if (index < sequenceIndex) {
                dnaSequence = arr;
                bestSequenceIndex = count;
                bestSequenceSum = sum;
                sequenceIndex = index;
            }
            input = scanner.nextLine();
        }
        if (bestSequenceSum == 0) {
            bestSequenceIndex = 1;
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSequenceIndex, bestSequenceSum);
        for (int value : dnaSequence) {
            System.out.print(value + " ");
        }

    }
}
