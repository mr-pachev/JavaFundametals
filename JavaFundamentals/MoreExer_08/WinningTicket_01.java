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

        String[] ticketsArr = scanner.nextLine().split("[,\\s]+");

        for (int i = 0; i < ticketsArr.length; i++) {
            String ticket = ticketsArr[i];

            if (ticketsArr[i].length() == 20) { //проверка дали думата е 20 символа
                String leftPart = left(ticket);
                String rightPart = right(ticket);

                Pattern pattern = Pattern.compile("[@]{6,10}|[#]{6,10}|[$]{6,10}|[\\\\^]{6,10}");
                Matcher matcher = pattern.matcher(leftPart);

                String leftMatch = "";
                String rightMatch = "";

                while (matcher.find()) {
                    leftMatch = matcher.group();
                }

                matcher = pattern.matcher(rightPart);

                while (matcher.find()) {
                    rightMatch = matcher.group();
                }

                if (leftMatch.equals("") || rightMatch.equals("")) {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                } else if (leftMatch.equals(rightMatch)) {
                    if (leftMatch.length() == 10) {
                        System.out.printf("ticket \"%s\" - %d%c Jackpot!%n", ticket, 10, ticket.charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - %d%c%n", ticket, leftMatch.length(), leftMatch.charAt(0));
                    }
                }
            } else {
                System.out.println("invalid ticket");
            }

        }

    }

    public static String left(String word) {
        StringBuilder leftWord = new StringBuilder();
        for (int i = 0; i < word.length() / 2; i++) {
            char letter = word.charAt(i);
            leftWord.append(letter);
        }
        return leftWord.toString();
    }

    public static String right(String word) {
        StringBuilder rightWord = new StringBuilder();
        for (int i = word.length() / 2; i < word.length(); i++) {
            char letter = word.charAt(i);
            rightWord.append(letter);
        }
        return rightWord.toString();
    }
}