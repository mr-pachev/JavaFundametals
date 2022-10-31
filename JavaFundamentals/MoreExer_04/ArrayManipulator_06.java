package MoreExer_04;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArray = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();
        int[] exchangeArr = new int[numArray.length];

        while (!input.equals("end")) {
            int index = 0;
            String command = input.split(" ")[0];
            String oddOrEven = "";
            boolean isExist = false;

            if (command.equals("exchange")) {
                index = Integer.parseInt(input.split(" ")[1]);

                if (isValid(numArray, index)) {
                    int currentIndex = 0;
                    for (int i = index + 1; i <= numArray.length - 1; i++) {

                        exchangeArr[currentIndex] = numArray[i];
                        currentIndex++;
                    }
                    for (int i = 0; i <= index; i++) {
                        exchangeArr[currentIndex] = numArray[i];
                        currentIndex++;
                    }
                    for (int i = 0; i <= numArray.length - 1; i++) {
                        numArray[i] = exchangeArr[i];
                    }
                } else {
                    System.out.println("Invalid index");
                }
            } else if (command.equals("max")) {
                oddOrEven = input.split(" ")[1];
                int maxOdd = 0;
                int maxEven = 0;
                int maxNumIndex = 0;

                if (oddOrEven.equals("odd")) {
                    for (int i = 0; i <= numArray.length - 1; i++) {
                        if (numArray[i] % 2 != 0) {
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
                        if (numArray[i] % 2 == 0) {
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
                if (isExist) {
                    System.out.println(maxNumIndex);
                }
            } else if (command.equals("min")) {
                oddOrEven = input.split(" ")[1];
                int minOdd = 0;
                int minEven = 0;
                int minNumIndex = 0;

                if (oddOrEven.equals("odd")) {
                    for (int i = 0; i <= numArray.length - 1; i++) {
                        if (numArray[i] % 2 != 0) {
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
                        if (numArray[i] % 2 == 0) {
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
                if (isExist) {
                    System.out.println(minNumIndex);
                }
            } else if (command.equals("first")) {
                int countElements = Integer.parseInt(input.split(" ")[1]);
                oddOrEven = input.split(" ")[2];
                int count = 1;

                if (countElements > numArray.length) {
                    System.out.println("Invalid count");
                    input = scanner.nextLine();
                    continue;
                }
                if (oddOrEven.equals("odd")) {
                    System.out.print("[");
                    for (int i = 0; i <= numArray.length - 1; i++) {
                        if (numArray[i] % 2 != 0 && count <= countElements) {
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
                    for (int i = 0; i <= numArray.length - 1; i++) {
                        if (numArray[i] % 2 == 0 && count <= countElements) {
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
            } else if (command.equals("last")) {
                int countElements = Integer.parseInt(input.split(" ")[1]);
                oddOrEven = input.split(" ")[2];
                int count = 1;

                if (countElements > numArray.length) {
                    System.out.println("Invalid count");
                    input = scanner.nextLine();
                    continue;
                }
                if (oddOrEven.equals("odd")) {
                    System.out.print("[");
                    for (int i = 0; i <= numArray.length - 1; i++) {
                        if (numArray[i] % 2 != 0 && count <= countElements) {
                            if (i >= numArray.length - countElements) {
                                System.out.print(numArray[i]);
                                countElements++;
                            }
                        }
                    }
                    System.out.println("]");
                } else if (oddOrEven.equals("even")) {
                    System.out.print("[");
                    for (int i = 0; i <= numArray.length - 1; i++) {
                        if (numArray[i] % 2 == 0 && count >= countElements) {
                            if (i >= numArray.length - countElements) {
                                System.out.print(numArray[i]);
                                countElements++;
                            }
                        }
                    }
                    System.out.println("]");
                }
            }
            input = scanner.nextLine();
        }
        int counter = 0;
        System.out.print("[");
        for (int current : numArray) {
            if (counter == 0){
                System.out.printf("%d", current);
            }else {
                System.out.printf(", %d", current);
            }
            counter++;
        }
        System.out.print("]");
    }

    public static boolean isValid(int[] array, int index) {
        if (index >= 0 && index <= array.length - 1) {
            return true;
        }
        return false;
    }
}
