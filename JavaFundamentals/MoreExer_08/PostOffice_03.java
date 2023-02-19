package MoreExer_08;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PostOffice_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|"); //входни данни

        Pattern lettersPattern = Pattern.compile("([#\\$%\\*&])(?<letters>[A-Z]+)(?:\\1)"); //regex за главните букв
        Matcher matcherLettersCase = lettersPattern.matcher(input[0]);

        String upperCaseLetters = "";

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
            firstLetterWordLengthMap.put(letter, wordLength + 1);
        }

        List<String> partTreeWordsList = Arrays.asList(input[2].split(" ")); //отделните думи от втората част ги запазваме в списък за  проверка

        for (int i = 0; i < upperCaseArr.length; i++) { //обхождаме масива с главните букви от първата част и спрямо него принтираме

            for (int j = 0; j < partTreeWordsList.size(); j++) { //обхождаме списъка с коректните думи от третата част и проверяваме коя дума е наред за принтиране спрямо първоначалния масив с главни букви
                char current = partTreeWordsList.get(j).charAt(0); //конкретната дума от списъка взимаме й първата буква
                int currentLength = partTreeWordsList.get(j).length(); //дължината на конкретната дума от списъка

                if (upperCaseArr[i] == current
                   && currentLength == firstLetterWordLengthMap.get(current)){ //проверка дали поредната главна буква от масива сътветства на дума от листа
                    System.out.println(partTreeWordsList.get(j));
                }
            }
        }

    }
}
