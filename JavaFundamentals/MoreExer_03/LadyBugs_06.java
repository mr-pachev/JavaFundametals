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

                if (bugs[j] == i && bugs[j] >= 0 && bugs[j] < fieldArr.length) {
                    fieldArr[i] = 1;
                }
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            int oldIndex = Integer.parseInt(input.split("\\s+")[0]);
            String direction = input.split("\\s+")[1];
            int newIndex = Integer.parseInt(input.split("\\s+")[2]);

            if (oldIndex < 0 || oldIndex > fieldArr.length-1 || fieldArr[oldIndex] == 0){   //проверка дали индекса е извън масива и дали на този индекс има калинка
                input = scanner.nextLine();
                continue;
            }

            fieldArr[oldIndex] = 0;                  //калинката отлита от индекса и стова 0

            if (direction.equals("right")) {
                oldIndex += newIndex;                //пресмята индекса, на който трябва да кацне калинката спрямо стъката

                while (oldIndex < field && fieldArr[oldIndex] == 1) {                       //проверка дали НОВАТА стойност oldIndex е в горната граница на полето и дали каца на индекс с калинка
                    oldIndex += newIndex;
                }

                if (oldIndex < field) {             //проверка дали все още индекса е в полето
                    fieldArr[oldIndex] = 1;         //отразяваме, че на индекса има вече калинка
                }

            }else if (direction.equals("left")){   //обратна но горната логика
                oldIndex -= newIndex;

                while (oldIndex >= 0 && fieldArr[oldIndex] == 1){
                    oldIndex -= newIndex;
                }

                if (oldIndex >= 0){
                    fieldArr[oldIndex] = 1;
                }
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < fieldArr.length; i++) {
            System.out.printf("%d ", fieldArr[i]);
        }
    }
}