package Exercises._05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String comand = input.split(" ")[0];

            switch (comand) {

                case "Delete":
                    int element = Integer.parseInt(input.split(" ")[1]);
                    numbersList.removeAll(Arrays.asList(element));
                    break;

                case "Insert":
                    element = Integer.parseInt(input.split(" ")[1]);
                    int index = Integer.parseInt(input.split(" ")[2]);
                    numbersList.add(index, element);
                    break;
            }
            input = scanner.nextLine();
        }
        for (int num : numbersList) {
            System.out.print(num + " ");
        }
    }
}
