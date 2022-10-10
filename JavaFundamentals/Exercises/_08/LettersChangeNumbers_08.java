package Exercises._08;

import java.util.Scanner;

public class LettersChangeNumbers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String incoming = scanner.nextLine();

        String[] codes = incoming.split("\\s+");
        double sum = 0;

        for (String currentCodes : codes) {

            sum += getSum(currentCodes);
        }

        System.out.printf("%.2f", sum);
    }

    public static Double getSum(String cod) {

        double sum = 0;
        double result = 1; //резултат от аритметичните действия в метода

        char firstLetter = cod.charAt(0); // първа буква, като символ
        char lastLetter = cod.charAt(cod.length() - 1); // втора буква, като символ
        double digit = Double.parseDouble(cod.replace(firstLetter, ' ') //числото, като double
                .replace(lastLetter, ' ')
                .trim());

                // действия първа буква
        if (Character.isUpperCase(firstLetter)) { //проверка дали първата буква е главна
            int position = (int) firstLetter - 64;
            result = digit / position;
            sum += result;

        } else if (Character.isLowerCase(firstLetter)) { //проверка дали първата буква е малка
            int position = (int) firstLetter - 96;
            result = digit * position;
            sum += result;
        }
            // действие последна буква
        if (Character.isUpperCase(lastLetter)) { //проверка дали първата буква е главна
            int position = (int) lastLetter - 64;

            sum -= position;

        } else if (Character.isLowerCase(lastLetter)) { //проверка дали първата буква е малка
            int position = (int) lastLetter - 96;
            sum += position;
        }
        return sum;
    }
}
