package FinalExams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheImitationGame_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String message = scan.nextLine();

        String input = scan.nextLine();

        while (!input.equals("Decode")) {
            String[] tokens = input.split("\\|");
            String action = tokens[0];

            switch (action) {
                case "Move": {
                    int numLetters = Integer.parseInt(tokens[1]);

                    String firstPart = message.substring(0, numLetters);
                    String secondPart = message.substring(numLetters);
                    message = secondPart.concat(firstPart);
                    break;
                }
                case "Insert": {
                    int index = Integer.parseInt(tokens[1]);
                    String element = tokens[2];

                    String firstPart = message.substring(0, index);
                    String secondPart = message.substring(index);
                    message = firstPart.concat(element).concat(secondPart);
                    break;
                }
                case "ChangeAll": {
                    String substring = tokens[1];
                    String replacement = tokens[2];

                    message = message.replace(substring, replacement);
                    break;
                }
            }

            input = scan.nextLine();
        }

        System.out.printf("The decrypted message is: %s%n", message);
    }
}
