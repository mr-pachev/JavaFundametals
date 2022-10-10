package Exercises._04;

import java.util.Scanner;

public class CharactersInRange_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);

        printChar(firstChar, secondChar);

    }

    private static void printChar(char one, char two) { // метод за принтиране поредица от символи в даден интервал
        int firstNum = one; // присвояване на целочислева стойност от чар
        int secondNum = two;
        int maxValue = 0; // задавене според целочислената стойност на чара поредицата за принтиране
        int minValue = 0;

        if (firstNum >= secondNum) { // определяне началото и края на поредицата от ASCII таблицата за принтиране
            maxValue = firstNum;
            minValue = secondNum;
        } else {
            maxValue = secondNum;
            minValue = firstNum;
        }

        for (int i = minValue + 1; i <= maxValue - 1; i++) { // цикъл за обхождане на цикъла без първия и последния чар
            char current = (char) i;
            System.out.print(current + " ");
        }
    }
}
