package Exercises._03;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int num = Integer.parseInt(scanner.nextLine());

        int currentElement = 0;
        int compareElement = 0;

        for (int index = 0; index <= arr.length - 1; index++) { // цикъл за обхождане на масива arr
            currentElement = arr[index]; // текущия елемент, чийто сбор с всеки следващ елементи до края на цикъла ще сравняваме с числото num

            for (int i = index; i < arr.length - 1; i++) { // цикъл за обхождане на масива след текущия елемент, дължината му е с един индекс по-къса от основния цикъл
                compareElement = arr[i + 1];
                if (currentElement + compareElement == num) {
                    System.out.print(currentElement + " ");
                    System.out.println(compareElement + " ");
                }
            }
        }
    }
}
