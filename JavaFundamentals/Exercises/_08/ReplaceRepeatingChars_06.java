package Exercises._08;

import java.util.Scanner;

public class ReplaceRepeatingChars_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String resultString = "";
        char firstSymbol = input.charAt(0);
        resultString = resultString + firstSymbol;

        for (int i = 0; i < input.length() ; i++) {
            char current = input.charAt(i);

            if(current != firstSymbol){
                resultString += current;
                firstSymbol = current;
            }
        }
        System.out.println(resultString);
    }
}
