package MoreExer_07;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExtractPersonInformation_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder resultName = new StringBuilder();
        StringBuilder resultAge = new StringBuilder();

        for (int row = 1; row <= n; row++) {
            String input = scanner.nextLine();

            String[] personDataArr = input.split("[@|]");
            String[] personData1Arr = input.split("[#*]");

            String name = personDataArr[1];
            String age = personData1Arr[1];

            resultName.append(name);
            resultAge.append(age);

            System.out.println(resultName + " is " + resultAge + " years old.");

            resultName.delete(0, resultName.length());
            resultAge.delete(0, resultAge.length());
        }

    }
}
