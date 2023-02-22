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

        Pattern pattern = Pattern.compile("([#\\|])(?<name>[A-Z][a-z]+[ ]*)(?:\\1)(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})(?:\\1)(?<cal>[0-9]{0,5})(?:\\1)");
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

        
    }
}
