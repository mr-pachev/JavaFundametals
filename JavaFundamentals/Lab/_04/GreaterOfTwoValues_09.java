package Lab._04;

import java.util.Scanner;

public class GreaterOfTwoValues_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputType = scanner.nextLine();

        switch (inputType) {
            case "int": {
                int incomingFirst = Integer.parseInt(scanner.nextLine());
                int incominSecond = Integer.parseInt(scanner.nextLine());
                System.out.println(compareValue(incomingFirst, incominSecond));
                break;
            }
            case "char": {
                char incomingFirst = scanner.nextLine().charAt(0);
                char incomingSecod = scanner.nextLine().charAt(0);
                System.out.println(compareValue(incomingFirst, incomingSecod));
                break;
            }
            case "string": {
                String incomingFirst = scanner.nextLine();
                String incomingSecond = scanner.nextLine();
                System.out.println(compareValue(incomingFirst, incomingSecond));
                break;
            }
        }
    }

    public static int compareValue(int first, int second) {
        int maxValue = 0;
        if (first > second) {
            maxValue = first;
        } else if (second > first) {
            maxValue = second;
        }
        return maxValue;
    }

    public static char compareValue(char first, char second) {
        char maxValue = 0;
        if (first > second) {
            maxValue = first;
        } else if (second > first) {
            maxValue = second;
        }
        return maxValue;
    }

    public static String compareValue(String first, String second) {
        String maxValue = "";
        if (first.compareTo(second) > 0) {
            maxValue = first;
        } else {
            maxValue = second;
            ;
        }
        return maxValue;
    }

}
