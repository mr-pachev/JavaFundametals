package MoreExer_04;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArray = Arrays.stream(scanner.nextLine() //входящ масив
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();
        int[] exchangeArr = new int[numArray.length]; //масив нужен за разместването

        while (!input.equals("end")) { //цикъл за команди
            int index = 0; //индекс на елемента
            String command = input.split(" ")[0]; //команда
            String oddOrEven = ""; //четна или нечетна-част от командата
            boolean isExist = false; //дали зададеният индекс или елемент съществува

            if (command.equals("exchange")) { //първа команда-EXCHANGE
                index = Integer.parseInt(input.split(" ")[1]);

                if (isValid(numArray, index)) { //проверка дали индекса е валиден
                    int currentIndex = 0;
                    for (int i = index + 1; i <= numArray.length - 1; i++) {

                        exchangeArr[currentIndex] = numArray[i];
                        currentIndex++;
                    }
                    for (int i = 0; i <= index; i++) { //запълване на масива с разместените елементи
                        exchangeArr[currentIndex] = numArray[i];
                        currentIndex++;
                    }
                    for (int i = 0; i <= numArray.length - 1; i++) { //промяна на основния масив
                        numArray[i] = exchangeArr[i];
                    }
                } else {
                    System.out.println("Invalid index");
                }

            } else if (command.equals("max")) { //втора команда-MAX
                oddOrEven = input.split(" ")[1];
                int maxOdd = 0;
                int maxEven = 0;
                int maxNumIndex = 0;
                if (oddOrEven.equals("odd")) {
                    for (int i = 0; i <= numArray.length - 1; i++) {
                        if (numArray[i] % 2 != 0) { //проверка за нечетни елементи в цикъла
                            if (maxOdd <= numArray[i]) {
                                maxOdd = numArray[i];
                                maxNumIndex = i;
                            }
                            isExist = true;
                        }
                    }
                    if (!isExist) {
                        System.out.println("No matches");
                    }
                } else if (oddOrEven.equals("even")) {
                    for (int i = 0; i <= numArray.length - 1; i++) {
                        if (numArray[i] % 2 == 0) { //проверка за четни елементи в цикъла
                            if (maxOdd <= numArray[i]) {
                                maxOdd = numArray[i];
                                maxNumIndex = i;
                            }
                            isExist = true;
                        }
                    }
                    if (!isExist) {
                        System.out.println("No matches");
                    }
                }
                if (isExist) { //печат на кройният резултат
                    System.out.println(maxNumIndex);
                }

            } else if (command.equals("min")) { //трета команда-MIN
                oddOrEven = input.split(" ")[1];
                int minOdd = 0;
                int minEven = 0;
                int minNumIndex = 0;
                if (oddOrEven.equals("odd")) {
                    for (int i = 0; i <= numArray.length - 1; i++) {
                        if (numArray[i] % 2 != 0) { //проверка за нечетни елементи в цикъла
                            if (minOdd >= numArray[i]) {
                                minOdd = numArray[i];
                                minNumIndex = i;
                            }
                            isExist = true;
                        }
                    }
                    if (!isExist) {
                        System.out.println("No matches");
                    }
                } else if (oddOrEven.equals("even")) {
                    for (int i = 0; i <= numArray.length - 1; i++) {
                        if (numArray[i] % 2 == 0) { //проверка за четни елементи в цикъла
                            if (minEven >= numArray[i]) {
                                minEven = numArray[i];
                                minNumIndex = i;
                            }
                            isExist = true;
                        }
                    }
                    if (!isExist) {
                        System.out.println("No matches");
                    }
                }
                if (isExist) { //печат на кройният резултат
                    System.out.println(minNumIndex);
                }

            } else if (command.equals("first")) { //четвърта команда-FIRST
                int countElements = Integer.parseInt(input.split(" ")[1]);
                oddOrEven = input.split(" ")[2];
                int count = 1;
                if (countElements > numArray.length) { //проверка дали заданието е валидно
                    System.out.println("Invalid count");
                    input = scanner.nextLine();
                    continue;
                }
                if (oddOrEven.equals("odd")) {
                    System.out.print("[");
                    for (int i = 0; i <= numArray.length - 1; i++) { //цикъл за намиране на първите елементи
                        if (numArray[i] % 2 != 0 && count <= countElements) { //принтиране само на първите намерени елементи
                            if (count == 1) {
                                System.out.print(numArray[i]);
                            } else {
                                System.out.printf(", %d", numArray[i]);
                            }
                            count++;
                        }
                    }
                    System.out.println("]");
                } else if (oddOrEven.equals("even")) {
                    System.out.print("[");
                    for (int i = 0; i <= numArray.length - 1; i++) { //цикъл за намиране на първите елементи
                        if (numArray[i] % 2 == 0 && count <= countElements) { //принтиране само на първите намерени елементи
                            if (count == 1) {
                                System.out.print(numArray[i]);
                            } else {
                                System.out.printf(", %d", numArray[i]);
                            }
                            count++;
                        }
                    }
                    System.out.println("]");
                }

            } else if (command.equals("last")) { //пета команда-LAST
                int countElements = Integer.parseInt(input.split(" ")[1]);
                oddOrEven = input.split(" ")[2];
                int count = 1;
                String  currentElements = ""; //събира всички намерените елементи от масива
                if (countElements > numArray.length) { //проверка дали заданието е валидно
                    System.out.println("Invalid count");
                    input = scanner.nextLine();
                    continue;
                }
                if (oddOrEven.equals("odd")) {
                    System.out.print("[");
                    for (int i = 0; i <= numArray.length - 1; i++) {
                        if (numArray[i] % 2 != 0) { //проверка за нечетни елементи в цикъла
                            currentElements += numArray[i];
                        }
                    }
                    for (int i = currentElements.length(); i > 0; i--) {//цикъл за принтиране на последните намерени елементи
                        String element = currentElements.split("")[(currentElements.length()) - i];
                        if (count == 1) {
                            System.out.print(element);
                        } else {
                            System.out.printf(", %s", element);
                        }
                        count++;
                    }

                    System.out.println("]");
                } else if (oddOrEven.equals("even")) {
                    System.out.print("[");
                    for (int i = 0; i <= numArray.length - 1; i++) {
                        if (numArray[i] % 2 == 0) { //проверка за четни елементи в цикъла
                            currentElements += numArray[i];
                        }
                    }
                    for (int i = currentElements.length(); i > 0; i--) {//цикъл за принтиране на последните намерени елементи
                        String element = currentElements.split("")[(currentElements.length()) - i];
                        if (count == 1) {
                            System.out.print(element);
                        } else {
                            System.out.printf(", %s", element);
                        }
                        count++;
                    }
                    System.out.println("]");
                }
            }
            input = scanner.nextLine();
        }

        //принтиране на масива
        int counter = 0;
        System.out.print("[");
        for (int current : numArray) {
            if (counter == 0) {
                System.out.printf("%d", current);
            } else {
                System.out.printf(", %d", current);
            }
            counter++;
        }
        System.out.print("]");
    }

    public static boolean isValid(int[] array, int index) { //метод за проверка валидността на индекса
        if (index >= 0 && index <= array.length - 1) {
            return true;
        }
        return false;
    }
}
