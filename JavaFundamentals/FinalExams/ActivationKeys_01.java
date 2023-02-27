package FinalExams;

import java.util.Scanner;

public class ActivationKeys_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String command = input.split(">>>")[0];

            switch (command) {
                case "Contains": {
                    String subs = input.split(">>>")[1];
                    if (text.contains(subs)) {
                        System.out.printf("%s contains %s%n", text, subs);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                }
                case "Flip": {
                    int startIndex = Integer.parseInt(input.split(">>>")[2]);
                    int endIndex = Integer.parseInt(input.split(">>>")[3]);
                    String firstPart = text.substring(0, startIndex);
                    String secondPart = text.substring(endIndex);
                    String subs = "";

                    if (input.split(">>>")[1].equals("Upper")) {
                        subs = text.substring(startIndex, endIndex).toUpperCase();
                    } else if (input.split(">>>")[1].equals("Lower")) {
                        subs = text.substring(startIndex, endIndex).toLowerCase();
                    }
                    text = firstPart.concat(subs).concat(secondPart);
                    System.out.println(text);
                    break;
                }
                case "Slice": {
                    int startIndex = Integer.parseInt(input.split(">>>")[1]);
                    int endIndex = Integer.parseInt(input.split(">>>")[2]);
                    String firstPart = text.substring(0, startIndex);
                    String secondPart = text.substring(endIndex);
                    text = firstPart.concat(secondPart);
                    System.out.println(text);
                    break;
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", text);
    }
}
