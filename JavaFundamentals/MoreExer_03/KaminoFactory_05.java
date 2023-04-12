package MoreExer_03;

import java.util.*;
import java.util.stream.Collectors;

public class KaminoFactory_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int maxSubsequence = Integer.MIN_VALUE; //съдържа на голямата последователност
        int minLeftIndex = Integer.MAX_VALUE;   //съдържа най-левия индекс на най-голямата последователност
        int maxSum = Integer.MIN_VALUE;         //съдържа най-голямата сума на най-голямата последователност
        int bestPosition = 0;
        int currentPosition = 0;
        int[] dnaArr = new int[n];

        String inputData = scanner.nextLine();

        while (!inputData.equals("Clone them!")) {
            currentPosition++;

            int[] dna = Arrays.stream(inputData.split("!+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int currentSubsequence = longSequence(dna);
            int currentLeftIndex = 0;
            int currentSum = 0;

            for (int i = 0; i < dna.length; i++) {
                if (i != dna.length - 1 && dna[i] == 1 && dna[i + 1] == 1) { //проверка, че има последователност
                    currentLeftIndex = i;
                }
                currentSum += dna[i];
            }

            if (currentSubsequence > maxSubsequence) {              //проверка дали дадената последователност е по-голяма от максималната до момента
                maxSubsequence = currentSubsequence;
                minLeftIndex = currentLeftIndex;
                bestPosition = currentPosition;
                maxSum = currentSum;
                dnaArr = dna;

            } else if (currentSubsequence == maxSubsequence) {
                if (currentLeftIndex < minLeftIndex) {              //при равни последователности сравнява най-левия индекс
                    minLeftIndex = currentLeftIndex;
                    bestPosition = currentPosition;
                    maxSum = currentSum;
                    dnaArr = dna;
                } else if (currentSum > maxSum) {                   //при равни последователности и равни индекси сравнява за по-голямата сума от индекси
                    minLeftIndex = currentLeftIndex;
                    bestPosition = currentPosition;
                    maxSum = currentSum;
                    dnaArr = dna;
                }

            }

            inputData = scanner.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestPosition, maxSum);
        for (int s : dnaArr) {
            System.out.printf("%s ", s);
        }

    }

    //метод за номиране броя на най-дългата последователност от 1
    public static Integer longSequence(int[] arr) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                sum++;
            } else {
                sum = 0;
            }

            if (sum >= max) {
                max = sum;
            }
        }
        return max;
    }
}
