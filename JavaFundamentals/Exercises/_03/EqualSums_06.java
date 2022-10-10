package Exercises._03;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arr[] = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int leftSum = 0;
        int rightSum = 0;
        boolean isValid = true;

        for (int index = 0; index <= arr.length - 1; index++) { //обхожда се целия масив

            leftSum = 0;
            rightSum = 0;

            for (int leftArr = 0; leftArr < index; leftArr++) { //обхожда се масива от индекс 0 до текущия индекс без него
                leftSum += arr[leftArr]; //сумират се елементите до текущи елемент без него
            }
            for (int rightArr = index + 1; rightArr <= arr.length - 1; rightArr++) { //обхожда се масива след текущия индекс до края на масива
                rightSum += arr[rightArr]; //сумират се елементите след текущия елемент до последния включително
            }
            if (leftSum == rightSum) {
                System.out.println(index);
                isValid = false;
                break;
            }
        }
        if (isValid) {// изпринтиране на no при липса на равенство но сумите
            System.out.println("no");
        }
    }
}
