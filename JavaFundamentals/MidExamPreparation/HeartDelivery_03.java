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
        boolean isEnough = false;
        int currentPosition = 0;
        boolean isPass = false;

        for (int indexArr = 0; indexArr <= neighborhoodArr.length - 1; indexArr++) {

            if (!input.equals("Love!")) {
                String[] inputArr = input.split(" ");
                int jumpPower = Integer.parseInt(inputArr[1]); //сила на скока
                currentPosition = indexArr + jumpPower;

                if (isOutside(indexArr, jumpPower, neighborhoodArr)) { //проверка дали скока ще излезе от масива
                    currentPosition = 0;
                    indexArr = - 1;
                    isPass = false;
                }
                int currentElement = neighborhoodArr[currentPosition]; //текущия елемент

                if (currentElement >= 2) { //проверка дали къщата ще се пропусне
                    currentElement -= 2;
                    isPass = false;
                    neighborhoodArr[currentPosition] = currentElement;
                } else if (!isPass){
                    isPass = true;
                    System.out.printf("Place %d already had Valentine's day.%n", currentPosition);
                }

                if (currentElement == 0 && !isPass){ //проверка дали посетената къща няма нужда от сърца вече
                    System.out.printf("Place %d has Valentine's day.%n", currentPosition);
                }
                input = scanner.nextLine();
            }else {
                System.out.printf("Cupid's last position was %d.%n", currentPosition);
                if (isSuccessful(neighborhoodArr)){
                    System.out.println("Mission was successful.");
                }else {
                    System.out.printf("Cupid has failed %d places.%n", notSuccessfulPlaces(neighborhoodArr));
                }
                isEnough = true;
                break;
            }
            if (isEnough){
                break;
            }
        }

    }

    //проверка дали скока надхвърля масива
    public static boolean isOutside(int currentIndex, int jump, int[] currentArr) {
        return (currentIndex + jump > currentArr.length - 1);
    }

    //проверка дали мавива съдържа само нулеви елементи
    public static boolean isSuccessful (int[] currentArr){
        boolean isTrue = true;
        int element = 0;
        for (int i = 0; i <= currentArr.length - 1; i++) {
            element = currentArr[i];
            if (element != 0){
                isTrue = false;
                break;
            }
        }
        return isTrue;
    }

    //боряч на елементите различни от 0
    public static Integer notSuccessfulPlaces (int[] currentArr){
        int element = 0;
        int counterPlaces = 0;
        for (int i = 0; i <= currentArr.length - 1; i++) {
            element = currentArr[i];
            if (element != 0){
                counterPlaces++;
            }
        }
        return counterPlaces;
    }
}
