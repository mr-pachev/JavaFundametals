package FinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> destinations = new ArrayList<>();

        int points = 0;

        Pattern pattern = Pattern.compile("([=]|[\\/])(?<place>[A-Z][A-Z]{2,}|[A-Z][a-z]{2,})(?:\\1)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            String place = matcher.group("place");
            points += place.length();
            destinations.add(place);
        }

        System.out.print("Destinations: ");

        for (String s : destinations){
            System.out.print(s + ", ");
        }
    }
}
