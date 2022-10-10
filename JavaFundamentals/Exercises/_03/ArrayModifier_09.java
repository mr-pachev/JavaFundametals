package Exercises._03;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[] current = scanner.nextLine().split(" "); // въвеждане стринг масив и разделянето му по интервал

        while (!current[0].equals("end")) { // цикъл се върти до въвеждане на нулев индекс END

            switch (current[0]) {
                case "swap":
                    int index1 = Integer.parseInt(current[1]); // превръщането на индекс 1 от стренговия масив в цяло число
                    int firstElement = arr[index1];

                    int index2 = Integer.parseInt(current[2]); // // превръщането на индекс 2 от стренговия масив в цяло число
                    int secondElement = arr[index2];

                    arr[index1] = secondElement;
                    arr[index2] = firstElement;
                    break;
                case "multiply":
                    int indexMultiply1 = Integer.parseInt(current[1]); // превръщането на индекс 1 от стренговия масив в цяло число
                    int firstMultiplyElement = arr[indexMultiply1];

                    int indexMultiply2 = Integer.parseInt(current[2]); // // превръщането на индекс 2 от стренговия масив в цяло число
                    int secondMultiplyElement = arr[indexMultiply2];

                    arr[indexMultiply1] = firstMultiplyElement * secondMultiplyElement;
                    break;
                case "decrease":
                    for (int i = 0; i <= arr.length - 1; i++) {
                        arr[i] = arr[i] - 1;
                    }
            }
            current = scanner.nextLine().split(" "); // обновяване на цикъла от конзолата
        }

        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1]);
    }
}
