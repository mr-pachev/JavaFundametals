package Lab._09;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\b(?<day>\\d{2})(?<separtor>[/.\\-])(?<month>[A-Z][a-z]{2})(?:\\2)(?<year>\\d{4})\\b");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
        String current = matcher.group();
        String day = matcher.group("day");
        String month = matcher.group("month");
        String year = matcher.group("year");

            System.out.printf("Day: %s, Month: %s, Year: %s%n", day, month, year);
        }
    }
}
