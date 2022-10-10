package Exercises._09;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> nameRacersList = Arrays.stream(scanner.nextLine().split(", ")) //списък с имена на участници
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        Map<String, Integer> raceDataMap = new LinkedHashMap<>(); //мап, в който ще има имена на участници и пробягано разстояние

        for (String name : nameRacersList) { //запълване на речника с имената от листа
            raceDataMap.put(name, 0);
        }

        String nameRegex = "[A-Za-z]";
        String distanceRegex = "[0-9]";

        Pattern patternNameRacer = Pattern.compile(nameRegex);
        Pattern patternDistance = Pattern.compile(distanceRegex);

        while (!input.equals("end of race")) {
            Matcher matcherName = patternNameRacer.matcher(input);
            Matcher matcherDistance = patternDistance.matcher(input);
            String currentName = "";
            int sum = 0;

            while (matcherName.find()) {
               currentName += matcherName.group();
            }

            while (matcherDistance.find()) {
                int currentDistance = Integer.parseInt(matcherDistance.group());
                sum += currentDistance;
            }

            if(raceDataMap.containsKey(currentName)){ //проверка дали участника е листа с участниците(само техните резултати се взимат)
                int distace = raceDataMap.get(currentName);
                raceDataMap.put(currentName, distace + sum);
            }

            input = scanner.nextLine();
        }
        List<String> nameOfFirstThree = raceDataMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.println("1st place: " + nameOfFirstThree.get(0));
        System.out.println("2nd place: " + nameOfFirstThree.get(1));
        System.out.println("3rd place: " + nameOfFirstThree.get(2));
    }
}

