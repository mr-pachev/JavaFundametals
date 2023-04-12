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

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            int oldIndex = Integer.parseInt(input.split("\\s+")[0]);
            String direction = input.split("\\s+")[1];
            int newIndex = Integer.parseInt(input.split("\\s+")[2]);

            for (int i = 0; i < ; i++) {
                
            }

            input = scanner.nextLine();
        }

    }
}
