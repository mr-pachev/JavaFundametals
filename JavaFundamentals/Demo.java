import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int allCalories = 0;
        Map<String, List<String>> itemMap = new LinkedHashMap<>();
        List<String> data = new ArrayList<>();

        Pattern pattern = Pattern.compile("(#|[|])(?<name>[a-zA-Z\\s]+)\\1(?<date>[0-9]{2}/[0-9]{2}/[0-9]{2})\\1(?<calories>[0-9]{1,5})\\1");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String name = matcher.group("name");
            String date = matcher.group("date");
            String calories = matcher.group("calories");

            if (!itemMap.containsKey(name)) {
                data = new ArrayList<>();
                data.add(date);
                data.add(calories);
                itemMap.put(name, data);
                allCalories += Integer.parseInt(calories);
            }

        }

        int daysLive = allCalories / 2000;

        System.out.printf("You have food to last you for: %d days!%n", daysLive);

        if (!itemMap.isEmpty()) {
            for (Map.Entry<String, List<String>> entry : itemMap.entrySet()) {
                System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
            }
        }

    }
}
