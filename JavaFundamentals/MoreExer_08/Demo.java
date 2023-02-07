package MoreExer_08;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();                              //входни данни
        String[] wordsArr = input.split("(\\s+)*,(\\s+)*");       //масив с думи за проверка

        for (int numWords = 0; numWords < wordsArr.length; numWords++) {
            String currentWord = wordsArr[numWords];                    //конкретната дума

            Pattern pattern = Pattern.compile("(\\@{6,10}|\\${6,10}|\\^{6,10}|\\#{6,10})");
        }
    }
}
