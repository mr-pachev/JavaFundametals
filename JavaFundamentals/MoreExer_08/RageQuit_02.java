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
        StringBuilder word = new StringBuilder();
        int counterMatch = 0;

        while (matcher.find()) {

            String currentSymbol = matcher.group("symbol");
            int count = Integer.parseInt(matcher.group("count"));
            word.append(repeat(currentSymbol, count));

        }

        System.out.printf("Unique symbols used: %d%n", counterMatch);
        System.out.println(word);

    }
    static String repeat(String s, int repeatCount) {
        String[] repeatArr = new String[repeatCount];
        for (int i = 0; i < repeatCount; i++) {
            repeatArr[i] = s.toUpperCase();
        }
        return String.join("", repeatArr);
    }

}
