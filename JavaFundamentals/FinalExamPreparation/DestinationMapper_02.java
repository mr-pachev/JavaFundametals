package FinalExamPreparation;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String incoming = scanner.nextLine();

        Pattern pattern = Pattern.compile("(\\=|\\/)(?<destinacion>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(incoming);
        List<String> travelList = new ArrayList<>();
        int travelPoint = 0;

        while (matcher.find()){
            String currentDestination = matcher.group("destinacion");
            travelList.add(currentDestination);
            travelPoint = travelPoint + currentDestination.length();
        }
        System.out.print("Destinations: ");
        System.out.println(String.join(", ", travelList));
        System.out.printf("Travel Points: %d%n", travelPoint);
    }
}
