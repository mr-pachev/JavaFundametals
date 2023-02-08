package MoreExer_08;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;

public class RageQuit_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern patter = Pattern.compile("(?<symbol>[\\D]+)(?<count>[\\d]+)");
        Matcher matcher = patter.matcher(input);
        StringBuilder wordReplay = new StringBuilder();
        String uniqueSymbol = "";

        while (matcher.find()) {

            String currentSymbol = matcher.group("symbol");
            int counter = Integer.parseInt(matcher.group("count"));
            uniqueSymbol += (currentSymbol.toUpperCase());
            wordReplay.append(repeat(currentSymbol, counter));
        }

        String[] finalWord = wordReplay.toString().split("");

        Set<String> uniqueStrings = new LinkedHashSet<>();
        uniqueStrings.addAll(Arrays.asList(finalWord));

        System.out.printf("Unique symbols used: %d%n", uniqueStrings.size());
        System.out.println(wordReplay);

    }
    static String repeat(String s, int repeatCount) {
        String[] repeatArr = new String[repeatCount];
        for (int i = 0; i < repeatCount; i++) {
            repeatArr[i] = s.toUpperCase();
        }
        return String.join("", repeatArr);


    }

}
