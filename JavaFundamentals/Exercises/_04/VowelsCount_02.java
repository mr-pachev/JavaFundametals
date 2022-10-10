package Exercises._04;

import java.util.Scanner;

public class VowelsCount_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine().toLowerCase();

        System.out.println(getVowels(inputText));

    }
    private static int getVowels(String text){
        int counter = 0;
        for (char symbol : text.toCharArray()) {
            if (symbol == 'a' || symbol == 'o' || symbol == 'u' || symbol == 'e' || symbol == 'i'){
                counter += 1;
            }
        }
        return counter;
    }
}
