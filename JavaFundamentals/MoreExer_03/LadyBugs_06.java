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
                    if (isExistBug(fieldArr, oldIndex) && inTheBoarder(fieldArr, oldIndex) && newIndex > 0) { //проверка дали на дадения индекс има калинка и дали индекса на коленката е в полето
                        if (!isExistBug(fieldArr, oldIndex) && inTheBoarder(fieldArr, oldIndex + newIndex)) { //няма калинка на новия индекс
                            fieldArr[i] = 0;
                            fieldArr[newIndex] = 1;

                        } else if (isExistBug(fieldArr, oldIndex) && oldIndex + newIndex <= fieldArr.length - 1) {  //ако съществува буболечка но новия индекс, но е в греницата на масива
                            fieldArr[i] = 0;
                            fieldArr[newIndex + 1] = 1;
                        } else if (isExistBug(fieldArr, oldIndex) && oldIndex + newIndex > fieldArr.length - 1) {    //ако съществува буболечка но новия индекс и не е в греницата на масива
                            fieldArr[i] = 0;
                        }
                    }
                }

            }
            input = scanner.nextLine();
        }

        for (int j : fieldArr) {
            System.out.printf("%d ", j);
        }
    }

    //метод за проверка дали на дадения индекс има калинка
    public static boolean isExistBug(int[] arr, int index) {
        boolean existBug = false;
        for (int j = 0; j < arr.length; j++) {
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
