package MoreExer_08;

import com.sun.jdi.Value;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningTicket_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();                              //входни данни
        String[] wordsArr = input.split("(\\s+)*,(\\s+)*");       //масив с думи за проверка

        Map<String, Integer> symbolSumMapLeft = new LinkedHashMap<>();
        Map<String, Integer> symbolSumMapRight = new LinkedHashMap<>();

        for (int numWords = 0; numWords < wordsArr.length; numWords++) {
            char[] currentWord = wordsArr[numWords].toCharArray();      //символите на конкретната дума масив
            symbolSumMapLeft.put("#", 0);
            symbolSumMapLeft.put("@", 0);
            symbolSumMapLeft.put("$", 0);
            symbolSumMapLeft.put("^", 0);
            symbolSumMapRight.put("@", 0);
            symbolSumMapRight.put("#", 0);
            symbolSumMapRight.put("$", 0);
            symbolSumMapRight.put("^", 0);


            if (isExistSumChar(currentWord)) {                          //проверка дали думата съдържа 20 символа
                boolean isExist = false;
                for (int i = 0; i < currentWord.length / 2; i++) {
                    String currentSymbol = String.valueOf(currentWord[i]);
                    if (symbolSumMapLeft.containsKey(currentSymbol)) {
                        symbolSumMapLeft.put(currentSymbol, symbolSumMapLeft.get(currentSymbol) + 1);
                        isExist = true;
                    }
                }

                for (int i = currentWord.length - 1; i >= currentWord.length / 2; i--) {
                    String currentSymbol = String.valueOf(currentWord[i]);
                    if (symbolSumMapRight.containsKey(currentSymbol)) {
                        symbolSumMapRight.put(currentSymbol, symbolSumMapRight.get(currentSymbol) + 1);
                        isExist = true;
                    }
                }

                if (!isExist) {
                    System.out.printf("ticket \"%s\" - no match", wordsArr[numWords]);
                    continue;
                }

                symbolSumMapLeft = symbolSumMapLeft.entrySet().stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

                symbolSumMapRight = symbolSumMapRight.entrySet().stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

                String winSymbolLeft = "";
                int repeatingSymbolLeft = 0;
                for (Map.Entry<String, Integer> entry : symbolSumMapLeft.entrySet()) {
                    winSymbolLeft = entry.getKey();
                    repeatingSymbolLeft = entry.getValue();
                    break;
                }

                String winSymbolRight = "";
                int repeatingSymbolRight = 0;
                for (Map.Entry<String, Integer> entry : symbolSumMapRight.entrySet()) {
                    winSymbolRight = entry.getKey();
                    repeatingSymbolRight = entry.getValue();
                    break;
                }

                if (winSymbolLeft.equals(winSymbolRight)) {
                    if ((repeatingSymbolLeft >= 6 && repeatingSymbolLeft < 10)
                            && ((repeatingSymbolRight >= 6 && repeatingSymbolRight < 10))) {

                        if(repeatingSymbolLeft > repeatingSymbolRight){
                            System.out.printf("ticket \"%s\" - %d%s%n", wordsArr[numWords], repeatingSymbolRight, winSymbolRight);
                        }else {
                            System.out.printf("ticket \"%s\" - %d%s%n", wordsArr[numWords], repeatingSymbolLeft, winSymbolLeft);
                        }


                    } else if (repeatingSymbolLeft == 10 && repeatingSymbolRight == 10) {
                        System.out.printf("ticket \"%s\" - %d%s Jackpot!%n", wordsArr[numWords], repeatingSymbolLeft, winSymbolLeft);
                    } else {
                        System.out.printf("ticket \"%s\" - no match", wordsArr[numWords]);
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match", wordsArr[numWords]);
                }

            } else {
                System.out.println("invalid ticket");
            }

        }
    }

    //проверка дали думата съдържа 20 символа
    static boolean isExistSumChar(char[] currentSymbol) {
        return currentSymbol.length == 20;
    }

}
