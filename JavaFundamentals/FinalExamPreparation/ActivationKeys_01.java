package FinalExamPreparation;

import java.util.Scanner;

public class ActivationKeys_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();

        String command = scanner.nextLine();

        while (!command.equals("Generate")) {
            int strartIndex = 0;
            int endIndex = 0;
            String substring = "";

            if (command.contains("Contains")) {
                substring = command.split(">>>")[1];

                if (activationKey.contains(substring)) {
                    System.out.printf("%s contains %s%n", activationKey, substring);
                } else {
                    System.out.println("Substring not found!");
                }

            } else if (command.contains("Flip")) {
                String upOrLowerCase = command.split(">>>")[1];
                strartIndex = Integer.parseInt(command.split(">>>")[2]);
                endIndex = Integer.parseInt(command.split(">>>")[3]);
                substring = activationKey.substring(strartIndex, endIndex);

                if (upOrLowerCase.contains("Upper")) {
                    activationKey = activationKey.replace(substring, substring.toUpperCase());
                } else if (upOrLowerCase.contains("Lower")) {
                    activationKey = activationKey.replace(substring, substring.toLowerCase());
                }
                System.out.println(activationKey);

            } else if (command.contains("Slice")) {
                strartIndex = Integer.parseInt(command.split(">>>")[1]);
                endIndex = Integer.parseInt(command.split(">>>")[2]);
                substring = activationKey.substring(strartIndex, endIndex);
                activationKey = activationKey.replace(substring, "");

                System.out.println(activationKey);
            }

            command = scanner.nextLine();
        }

        System.out.printf("Your activation key is: %s%n", activationKey);
    }
}
