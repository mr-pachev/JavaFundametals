package MoreExer_08;

import com.sun.jdi.Value;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();                              //входни данни
        String[] wordsArr = input.split("(\\s+)*,(\\s+)*");       //масив с думи за проверка
        
        Map<String, Integer> symbolSumMap = new LinkedHashMap<>();

        for (int numWords = 0; numWords < wordsArr.length; numWords++) {
            char[] currentWord = wordsArr[numWords].toCharArray();      //символите на конкретната дума масив

            if (isExistSumChar(currentWord)) {                          //проверка дали думата съдържа 20 символа

                Pattern pattern = Pattern.compile("[@$#\\^]+");
                Matcher mather = pattern.matcher(Arrays.toString(currentWord));

                symbolSumMap.put("@", 0);
                symbolSumMap.put("#", 0);
                symbolSumMap.put("$", 0);
                symbolSumMap.put("^", 0);

                while (mather.find()){
                    String currentSymbol = mather.group();
                    switch (currentSymbol){
                        case "@":
                            symbolSumMap.put("@", symbolSumMap.get("@") + 1);
                            break;
                        case "#":
                            symbolSumMap.put("#", symbolSumMap.get("#") + 1);
                            break;
                        case "$":
                            symbolSumMap.put("$", symbolSumMap.get("$") + 1);
                            break;
                        case "^":
                            symbolSumMap.put("^", symbolSumMap.get("^") + 1);
                            break;
                    }
                    System.out.println();
                }

            } else {
                System.out.println("invalid ticket");
            }
            System.out.println();
        }

    }

    //проверка дали думата съдържа 20 символа
    static boolean isExistSumChar(char[] currentSymbol) {
        return currentSymbol.length == 20;
    }

}
