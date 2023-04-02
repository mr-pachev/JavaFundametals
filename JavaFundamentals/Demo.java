import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destinations = scanner.nextLine();

        List<String> pointsList = new ArrayList<>();
        int countPoints = 0;

        Pattern pattern = Pattern.compile("([\\/]|[\\=])(?<word>[A-Z][A-z]{2,})\\1");
        Matcher matcher = pattern.matcher(destinations);

        while (matcher.find()) {
            String destination = matcher.group("word");
            pointsList.add(destination);
            countPoints += destination.length();
        }

        System.out.print("Destinations: ");
        System.out.println(pointsList.toString().replaceAll("[\\[\\]]", ""));
        System.out.printf("Travel Points: %d", countPoints);

    }
}
