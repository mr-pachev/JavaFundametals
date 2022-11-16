package MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] neighborhoodArr = Arrays.stream(scanner.nextLine()
                        .split("@"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String input = scanner.nextLine();

        int currentPosition = 0; //тещуща позиция със скока

        while (!input.equals("Love!")) {
            String[] inputArr = input.split(" ");
            int jumpPower = Integer.parseInt(inputArr[1]); //сила на скока

            currentPosition += jumpPower;
            if (isOutside(currentPosition, neighborhoodArr)) { //проверка дали скока ще излезе от масива
                currentPosition = 0;
            }

            int currentElement = neighborhoodArr[currentPosition]; //текущия елемент

            if (currentElement == 0) { //проверка дали посетената къща вече е имало Св. Валентин
                System.out.printf("Place %d already had Valentine's day.%n", currentPosition);
            } else { //проверка дали къщата ще се пропусне
                currentElement -= 2;
                neighborhoodArr[currentPosition] = currentElement;

                if (currentElement == 0) { //проверка дали в дадената къща е станало Св. Валентин
                    System.out.printf("Place %d has Valentine's day.%n", currentPosition);
                }
            }
            input = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.%n", currentPosition);
        if (isSuccessful(neighborhoodArr)) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.%n", notSuccessfulPlaces(neighborhoodArr));
        }
    }

    //проверка дали скока надхвърля масива
    public static boolean isOutside(int currentIndex, int[] currentArr) {
        return (currentIndex > currentArr.length - 1);
    }

    //проверка дали мавива съдържа само нулеви елементи
    public static boolean isSuccessful(int[] currentArr) {
        boolean isTrue = true;
        int element = 0;
        for (int i = 0; i <= currentArr.length - 1; i++) {
            element = currentArr[i];
            if (element != 0) {
                isTrue = false;
                break;
            }
        }
        return isTrue;
    }

    //боряч на елементите различни от 0
    public static Integer notSuccessfulPlaces(int[] currentArr) {
        int element = 0;
        int counterPlaces = 0;
        for (int i = 0; i <= currentArr.length - 1; i++) {
            element = currentArr[i];
            if (element != 0) {
                counterPlaces++;
            }
        }
        return counterPlaces;
    }
}
