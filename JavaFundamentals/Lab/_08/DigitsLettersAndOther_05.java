package Lab._08;

import java.util.Scanner;

public class DigitsLettersAndOther_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String insert = scanner.nextLine();

        StringBuilder digit = new StringBuilder();
        StringBuilder letter = new StringBuilder();
        StringBuilder other = new StringBuilder();

        for (int i = 0; i < insert.length(); i++) {
            char currentSymbol = insert.charAt(i);

            if(Character.isDigit(currentSymbol)){
                digit.append(currentSymbol);
            }else if(Character.isLetter(currentSymbol)){
                letter.append(currentSymbol);
            }else {
                other.append(currentSymbol);
            }
        }
        System.out.println(digit.toString());
        System.out.println(letter.toString());
        System.out.println(other.toString());
    }
}
