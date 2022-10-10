package Exercises._03;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] num = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean isTrue = true;
        int curerntIndex = 0;

        for (int index = 0; index <= num.length - 1; index++) {// цикъл за обхождане на масива
            isTrue = false;
            curerntIndex = num[index];
            int compareIndex = 0;

            for (int nextIndex = index + 1; nextIndex <= num.length - 1; nextIndex++) {// цикъл за обхождане на масива и сравня на текущия индекс(currentIndex) с останалите до края на масива
                compareIndex = num[nextIndex];
                if (curerntIndex > compareIndex) {// сравнение на текущия елемент с останалите елементи един по един до края на останалия масив
                    isTrue = true;
                } else {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) {// проверка дали текущия елемент е по-голям от останалите елементи до края на масива
                System.out.print(num[index] + " ");
            }
        }
        System.out.print(num[num.length - 1]);// принтиране на последния елемет от цикъла, защото винаги е по-голям(няма други след него)
    }
}
