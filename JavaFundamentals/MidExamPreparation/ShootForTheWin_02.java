package MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targetsArr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();
        int counterShotTargets = 0;

        while (!input.equals("End")) {
            int targetIndex = Integer.parseInt(input); //индекс на мишената

            if (!(isValid(targetIndex, targetsArr))) { //проверка валидността на индекса
                input = scanner.nextLine();
                continue;
            }

            int shotElement = targetsArr[targetIndex]; //стойност на мишената

            for (int index = 0; index <= targetsArr.length - 1; index++) {
                int currentElement = targetsArr[index]; //текущ елемент

                if (currentElement == -1) { //проверка дали текущия елемент е бил отстрелван
                    continue;
                } else {
                    if (targetIndex == index) { //проверка телущия индекс дали отговаря на зададения индекс
                        counterShotTargets++;
                        targetsArr[index] = -1;
                    } else if (shotElement > currentElement) {
                        targetsArr[index] = currentElement + shotElement;
                    } else {
                        targetsArr[index] = currentElement - shotElement;
                    }

                }



            }


            input = scanner.nextLine();
        }

        System.out.printf("Shot targets: %d -> ", counterShotTargets);
        for (int element : targetsArr) {
            System.out.printf("%d ", element);
        }
    }

    //проверка за валидност на индекса
    public static boolean isValid(int index, int[] numArr) {
        return index >= 0 && index <= numArr.length - 1;
    }
}
