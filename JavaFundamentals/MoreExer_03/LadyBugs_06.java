package MoreExer_03;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int field = Integer.parseInt(scanner.nextLine());
        int[] fieldArr = new int[field];

        int[] bugs = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < fieldArr.length; i++) { //инициализираме индексите, на които има калинки
            for (int j = 0; j < bugs.length; j++) {
                if (bugs[j] == i) {
                    fieldArr[i] = 1;
                }
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            int oldIndex = Integer.parseInt(input.split("\\s+")[0]);
            String direction = input.split("\\s+")[1];
            int newIndex = Integer.parseInt(input.split("\\s+")[2]);

            for (int i = 0; i < fieldArr.length; i++) {

                if (oldIndex == i) {
                    if (isExistBug(bugs, oldIndex) && inTheBoarder(fieldArr, oldIndex)) { //проверка дали на дадения индекс има калинка и дали индекса на коленката е в полето
                        if (!isExistBug(bugs, newIndex)) {
                            fieldArr[i] = 0;
                            fieldArr[newIndex] = 1;
                            bugs[oldIndex] = newIndex;
                        } else if (isExistBug(bugs, newIndex) && newIndex + 1 <= fieldArr.length - 1) {
                            fieldArr[i] = 0;
                            fieldArr[newIndex + 1] = 1;
                            bugs[oldIndex] = newIndex + 1;
                        } else if (isExistBug(fieldArr, newIndex) && newIndex + 1 > fieldArr.length - 1) {
                            fieldArr[i] = 0;
                            bugs[oldIndex] = 0;
                        }
                    }
                }

            }

            input = scanner.nextLine();
        }

    }

    //метод за проверка дали на дадения индекс има калинка
    public static boolean isExistBug(int[] arr, int index) {
        boolean existBug = false;
        for (int j : arr) {
            if (index == j) {
                existBug = true;
                break;
            }
        }
        return existBug;
    }

    //метод за проверка дали индекса с калинката е в полето
    public static boolean inTheBoarder(int[] arr, int index) {
        return index >= 0 && index < arr.length;
    }
}
