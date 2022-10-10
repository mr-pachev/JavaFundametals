package Exercises._04;

import java.util.Scanner;

public class MiddleCharacters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String incomingText = scanner.nextLine();
        printMiddleChar(incomingText);

    }

    private static void printMiddleChar(String text) {
        int firstSymbol = (text.length() / 2) - 1;
        int secondSymbol = text.length() / 2;

         if (text.length() % 2 != 0) {
            System.out.print(text.charAt(secondSymbol));
        }else if (text.length() % 2 == 0) {
             System.out.print("" + text.charAt(firstSymbol) + text.charAt(secondSymbol));
         }

    }
}
