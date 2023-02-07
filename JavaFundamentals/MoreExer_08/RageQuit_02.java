package MoreExer_08;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern patter = Pattern.compile("(?<symbol>[\\D]+)(?<count>[\\d]+)");
        Matcher matcher = patter.matcher(input);
        StringBuilder wordReplay = new StringBuilder();
        StringBuilder words = new StringBuilder();
        int counterMatch = 0;

        while (matcher.find()) {

            String currentSymbol = matcher.group("symbol");
            int counter = Integer.parseInt(matcher.group("count"));
            words.append(currentSymbol);
            wordReplay.append(repeat(currentSymbol, counter));
            counterMatch = (symbolCount(words.toString(), currentSymbol));
        }
        System.out.printf("Unique symbols used: %d%n", counterMatch);
        System.out.println(wordReplay);

    }
    static String repeat(String s, int repeatCount) {
        String[] repeatArr = new String[repeatCount];
        for (int i = 0; i < repeatCount; i++) {
            repeatArr[i] = s.toUpperCase();
        }
        return String.join("", repeatArr);
    }

    static Integer symbolCount(String word, String checkSymbol){
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {

            if (!word.contains(checkSymbol)){
                counter++;
            }
        }
        return counter;
    }
}
