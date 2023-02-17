package MoreExer_08;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|"); //входни данни

        Pattern lettersPattern = Pattern.compile("([#\\$%\\*&])(?<letters>[A-Z]+)(?:\\1)"); //regex за главните букви
        String upperCaseLetters = "";

        Matcher matcherLettersCase = lettersPattern.matcher(input[0]);

        while (matcherLettersCase.find()){
            upperCaseLetters = matcherLettersCase.group("letters");
        }
        char[] upperCaseArr = upperCaseLetters.toCharArray(); //масив с първата буква-главна от спредстоящите думи


        Pattern symbolCodePattern = Pattern.compile("(?<symbolCode>[0-9]{2}):(?<length>[0-9]{2})"); //regex за номера на първата буква от думата и последващата дължина
        Matcher symbolPattern = symbolCodePattern.matcher(input[1]);

        Map<Character, Integer> firstLetterWordLengthMap = new LinkedHashMap<>(); //речник с първата буква на думата и дължината й

        while (symbolPattern.find()){
            char letter = (char) Integer.parseInt(symbolPattern.group("symbolCode"));
            int wordLength = Integer.parseInt(symbolPattern.group("length"));
            firstLetterWordLengthMap.put(letter, wordLength);

        }

        Pattern wordsPattern = Pattern.compile("\\b([A-Z][a-z]+[#\\$%\\*&\\-][A-Z][a-z]+)|[A-Z][a-z]+\\b");
        Matcher wordsMatcher = wordsPattern.matcher(input[2]);

        while (wordsMatcher.find()){
            String currentWord = wordsMatcher.group();
            if (firstLetterWordLengthMap.containsKey(currentWord.toCharArray()[0])
                && (firstLetterWordLengthMap.get(currentWord.toCharArray()[0]) == currentWord.length()-1)){
                System.out.println(currentWord);
            }
        }

    }
}
