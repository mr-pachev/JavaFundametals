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


        Pattern pattern = Pattern.compile("([#]|[\\\\|])(?<name>[A-z\\s]+)\\1(?<date>[0-9]{2}[\\/][0-9]{2}[\\/][0-9]{2})\\1(?<calories>[0-9]{0,5})\\1");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            String name = matcher.group("name");
            String date = matcher.group("date");
            String calories = matcher.group("calories");

            List<String> data = new ArrayList<>();
            allCalories += Integer.parseInt(calories);
            data.add(date);
            data.add(calories);
            itemMap.put(name, data);
        }

        int daysLive = Math.abs(allCalories / 2000);

        System.out.printf("You have food to last you for: %d days!%n", daysLive);

        if (!itemMap.isEmpty()){
            
        }
    }
}
