package Exercises._05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String command = input.split(" ")[0];

            switch (command) {

                case "Add":
                    int elementAdd = Integer.parseInt(input.split(" ")[1]);
                    numbersList.add(elementAdd);
                    break;

                case "Insert":
                    int elementInsert = Integer.parseInt(input.split(" ")[1]);
                    int indexInsert = Integer.parseInt(input.split(" ")[2]);

                    if (isValidIndex(indexInsert, numbersList.size() - 1)) {
                        numbersList.add(indexInsert, elementInsert);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case "Remove":
                    int indexRemove = Integer.parseInt(input.split(" ")[1]);
                    if (isValidIndex(indexRemove, numbersList.size() - 1)) {
                        numbersList.remove(indexRemove);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case "Shift":
                    String shiftCommand = input.split(" ")[1];
                    int count = Integer.parseInt(input.split(" ")[2]);

                    if (shiftCommand.equals("left")) {
                        for (int i = 0; i < count; i++) {
                            int firstElement = numbersList.get(0);
                            numbersList.add(firstElement);
                            numbersList.remove(0);
                        }
                    } else if (shiftCommand.equals("right")) {
                        for (int i = 0; i < count; i++) {
                            int lastElement = numbersList.get(numbersList.size() - 1);
                            numbersList.add(0, lastElement);
                            numbersList.remove((numbersList.size() - 1));
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int num : numbersList) {
            System.out.print(num + " ");
        }
    }

    public static boolean isValidIndex(int index, int last) {
        int cuurentIndex = index;
        boolean isValid = false;
        if (cuurentIndex >= 0 && cuurentIndex <= last) {
            isValid = true;
        }
        return isValid;
    }


}
