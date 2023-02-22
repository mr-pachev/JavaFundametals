package FinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> resultList = new ArrayList<>();
        int sumCal = 0;

        Pattern pattern = Pattern.compile("([#\\|])(?<name>[a-zA-Z\\s]+)(?:\\1)(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})(?:\\1)(?<cal>[0-9]{1,5})(?:\\1)");
        Matcher matcher = pattern.matcher(input);

        while(matcher.find()){
            String foodName = matcher.group("name");
            String dataQuality = matcher.group("date");
            String calString = matcher.group("cal");
            resultList.add(foodName);
            resultList.add(dataQuality);
            resultList.add(calString);
            sumCal += Integer.parseInt(calString);
        }

        int count = 0;
        System.out.printf("You have food to last you for: %d days!%n", sumCal / 2000);
        for (int i = 0; i < resultList.size(); i++) {

            if (count == 0){
                System.out.printf("Item: %s, ", resultList.get(i));
                count++;
                continue;
            }
            if (count == 1){
                System.out.printf("Best before: %s, ", resultList.get(i));
                count++;
                continue;
            }
            if (count == 2) {
                System.out.printf("Nutrition: %s%n", resultList.get(i));
                count = 0;
            }
        }
    }
}
