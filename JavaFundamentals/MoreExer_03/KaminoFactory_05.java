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

            int currentSubsequence = lengthOfLIS(dna);
            int currentLeftIndex = leftIndex(dna);
            int currentSum = elementSum(dna);

            if (currentSubsequence > maxSubsequence) {          //проверка дали дадената последователност е по-голяма от максималната до момента
                maxSubsequence = currentSubsequence;
                minLeftIndex = currentLeftIndex;
                bestPosition = currentPosition;
                maxSum = currentSum;
                dnaArr = dna;

            } else if (currentSubsequence == maxSubsequence) {
                if (currentLeftIndex < minLeftIndex) {          //при равенство но последователностите проверява най-левия индекс
                    minLeftIndex = currentLeftIndex;
                    bestPosition = currentPosition;
                    maxSum = currentSum;
                    dnaArr = dna;

                } else if (currentLeftIndex == minLeftIndex) {
                    if (currentSum > maxSum) {                  //при еднакви индекси се проверява дали сумата от елементите е по-голяма
                        maxSum = currentSum;
                        bestPosition = currentPosition;
                        dnaArr = dna;
                    }
                }
            }

            inputData = scanner.nextLine();
        }


        System.out.printf("Best DNA sample %d with sum: %d.%n", bestPosition, maxSum);
        for (int s : dnaArr) {
            System.out.printf("%s ", s);
        }
    }

    //метод за намиране на най-дългата последователност в масив от тип int
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] max = new int[nums.length];
        Arrays.fill(max, 1);

        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max[i] = Math.max(max[i], max[j] + 1);
                }
            }
            result = Math.max(max[i], result);
        }
        return result;
    }

    //метод определящ най-левият индекс на най-дългата последователност
    public static int leftIndex(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int index = 0;
        int[] max = new int[nums.length];
        Arrays.fill(max, 1);

        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max[i] = Math.max(max[i], max[j] + 1);
                    index = i;
                }
            }
            result = Math.max(max[i], result);
        }
        return index - (result - 1);
    }

    //метод определащ сумата на елементите то масива
    public static Integer elementSum(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
