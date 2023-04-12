package MoreExer_03;

import java.util.*;
import java.util.stream.Collectors;

public class KaminoFactory_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<Integer, List<String>> dnaMap = new LinkedHashMap<>();
        dnaMap.put(n,new ArrayList<>());

        int maxSubsequence = 0; //съдържа на голямата последователност
        int minLeftIndex = 0;   //съдържа най-левия индекс на най-голямата последователност
        int maxSum = 0;         //съдържа най-голямата сума на най-голямата последователност
        int bestPosition = 0;
        int currentPosition = 0;

        String inputData = scanner.nextLine();

        while (!inputData.equals("Clone them!")) {
            currentPosition++;
            List<String> currentLsit = Arrays.stream(inputData.split("\\!")).collect(Collectors.toList());
            dnaMap.put(currentPosition, currentLsit);

            String[] input = inputData.split("\\!");
            int[] dna = new int[input.length];

            for (int i = 0; i < input.length; i++) {
                dna[i] = Integer.parseInt(input[i]);
            }

            int currentSubsequence = lengthOfLIS(dna);
            int currentLeftIndex = leftIndex(dna);
            int currentSum = elementSum(dna);

            if (currentSubsequence > maxSubsequence) {          //проверка дали дадената последователност е по-голяма от максималната до момента
                maxSubsequence = currentSubsequence;
                minLeftIndex = currentLeftIndex;
                bestPosition = currentPosition;
                maxSum = currentSum;

            } else if (currentSubsequence == maxSubsequence) {
                if (currentLeftIndex < minLeftIndex) {          //при равенство но последователностите проверява най-левия индекс
                    minLeftIndex = currentLeftIndex;
                    bestPosition = currentPosition;
                    maxSum = currentSum;

                } else if (currentLeftIndex == minLeftIndex) {
                    if (currentSum > maxSum) {                  //при еднакви индекси се проверява дали сумата от елементите е по-голяма
                        maxSum = currentSum;
                        bestPosition = currentPosition;
                    }
                }
            }

            inputData = scanner.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestPosition, maxSum);
        for (Map.Entry<Integer, List<String>> entry : dnaMap.entrySet()) {
            if (entry.getKey() == bestPosition) {
                System.out.println(entry.getValue().toString().replaceAll("[\\[\\],]", ""));
            }
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
