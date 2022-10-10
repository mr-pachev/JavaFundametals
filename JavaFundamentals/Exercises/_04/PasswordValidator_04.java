package Exercises._04;

import java.util.Scanner;

public class PasswordValidator_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if (!isValidCountChar(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!isValidLettersAndDigits(password)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!isValidTwooDigits(password)) {
            System.out.println("Password must have at least 2 digits");
        }

        if (isValidCountChar(password) && isValidLettersAndDigits(password) && isValidTwooDigits(password)) {
            System.out.println("Password is valid");
        }
    }

    // метод за проверка броя на знаците (от 6 до 10 включително)
    private static boolean isValidCountChar(String incomingText) {
        int counter = 0;
        for (char symbol : incomingText.toCharArray()) {
            counter += 1;
        }
        if (counter >= 6 && counter <= 10) {
            return true;
        } else {
            return false;
        }
    }

    // метод проверка дали паролата се състои само от букви и цифри
    private static boolean isValidLettersAndDigits(String incomingText) {
        for (char symbol : incomingText.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        return true;
    }

    // метод проверка дали в паролата има поне 2 цифри
    private static boolean isValidTwooDigits(String incomingText) {
        int counter = 0;
        for (char symbol : incomingText.toCharArray()) {
            if (Character.isDigit(symbol)) {
                counter += 1;
            }
        }
        if (counter >= 2) {
            return true;
        }
        return false;
    }
}
