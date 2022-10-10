package Lab._08;

import java.util.Scanner;

public class RepeatStrings_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] textArray = scanner.nextLine().split(" ");
        String sumWords = "";

        for (int i = 0; i < textArray.length; i++) {
            String cuurentWord = textArray[i];
            for (int j = 0; j < cuurentWord.length(); j++) {
                sumWords += textArray[i];
            }
        }
        System.out.println(sumWords);
    }
}
