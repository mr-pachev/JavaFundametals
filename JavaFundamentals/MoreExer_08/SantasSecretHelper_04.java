package MoreExer_08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wordKey = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        List<String> wordsList = new ArrayList<>(); //списък съдържащ думите за разкодиране

        while (!input.equals("end")) {              //пълнене на списъка
            wordsList.add(input);

            input = scanner.nextLine();
        }

        for (String s : wordsList) {                //обхаодане на списъка и създаване на масив от символи за всяка дума
            char[] currentWord = s.toCharArray();   //масива от конкретната дума

            String words = decodedWord(currentWord, wordKey); //декодираната дума

            Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^\\-@!:>]*!(?<behavior>[G])!"); //regex за името и държанието
            Matcher matcher = pattern.matcher(words);

            while (matcher.find()) {
                String name = matcher.group("name");
                String behavior = matcher.group("behavior");

                System.out.println(name);
            }
        }

    }

    //метод за връщаш декодирана дума
    public static String decodedWord(char[] currentArr, int key) {
        String decode = "";
        for (char c : currentArr) {
            char newSymbol = (char) (c - key);
            decode += newSymbol;
        }
        return decode;
    }
}
