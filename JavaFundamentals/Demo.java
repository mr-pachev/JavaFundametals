import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        double average = valueAverage(inputArr);

        int[] resultArr = new int[inputArr.length];

        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] > average) {
                resultArr[i] = inputArr[i];
            }
        }

        if (!isNegative(resultArr)) {
            resultArr = Arrays.stream(resultArr)
                    .boxed()
                    .sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();
        }

        if (Arrays.stream(resultArr).sum() == 0) {
            System.out.println("No");
        } else {
            for (int i = 0; i < 5; i++) {
                if (resultArr[i] != 0) {
                    System.out.printf("%d ", resultArr[i]);
                }
            }
        }
    }

    //метод за намиране средната стойност на елементите от масив
    public static Double valueAverage(int[] exampleArr) {
        double result = 0;
        for (int index = 0; index <= exampleArr.length - 1; index++) {
            result += exampleArr[index];
        }
        result = result / exampleArr.length;
        return result;
    }

    //проверка дали елементите са отрицателни числа
    public static boolean isNegative(int[]arr){
        boolean isNegative = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0){
                isNegative = false;
            }
        }
        return isNegative;
    }
}
