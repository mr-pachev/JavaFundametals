import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rawActivationKey = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String command = input.split(">>>")[0];

            switch (command) {
                case "Contains":
                    String subs = input.split(">>>")[1];

                    if (rawActivationKey.contains(subs)) {
                        System.out.printf("%s contains %s%n", rawActivationKey, subs);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;

                case "Flip":
                    String typeLetter = input.split(">>>")[1];
                    int startIndex = Integer.parseInt(input.split(">>>")[2]);
                    int endIndex = Integer.parseInt(input.split(">>>")[3]);

                    String firstPart = rawActivationKey.substring(0, startIndex);
                    String secondPart = rawActivationKey.substring(endIndex);

                    String flipString = rawActivationKey.substring(startIndex, endIndex);
                    flipString = typeLetters(flipString, typeLetter);

                    rawActivationKey = "";
                    rawActivationKey = firstPart.concat(flipString).concat(secondPart);
                    System.out.println(rawActivationKey);
                    break;

                case "Slice":
                    int firstIndex = Integer.parseInt(input.split(">>>")[1]);
                    int lastIndex = Integer.parseInt(input.split(">>>")[2]);

                    String startPart = rawActivationKey.substring(0, firstIndex);
                    String endPart = rawActivationKey.substring(lastIndex);

                    rawActivationKey = "";
                    rawActivationKey = startPart.concat(endPart);
                    System.out.println(rawActivationKey);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", rawActivationKey);
    }

    public static String typeLetters(String key, String type) {
        String letters = "";

        if (type.equals("Upper")) {
            letters = key.toUpperCase();
        } else if (type.equals("Lower")) {
            letters = key.toLowerCase();
        }
        return letters;
    }
}
