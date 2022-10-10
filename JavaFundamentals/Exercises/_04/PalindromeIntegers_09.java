package Exercises._04;

import java.util.Scanner;

public class PalindromeIntegers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String incoming = scanner.nextLine();

        while (!incoming.equals("END")) {

            if (isValid(incoming)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            incoming = scanner.nextLine();
        }

    }

    private static boolean isValid(String text) {
        String revers = "";
        boolean isTrue = false;

        for (int i = text.length() - 1; i >= 0; i--) {
            revers += text.charAt(i);
        }

        if (revers.equals(text)) {
            isTrue = true;
        }
        return isTrue;
    }
}

