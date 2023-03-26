import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> dataList = new ArrayList<>();
        Map<String, List<Integer>> conquestMap = new LinkedHashMap<>();
        int countCity = 0;

        while (!input.equals("Sail")) {
            String city = input.split("\\|\\|")[0];
            int people = Integer.parseInt(input.split("\\|\\|")[1]);
            int golds = Integer.parseInt(input.split("\\|\\|")[2]);

            if (!conquestMap.containsKey(city)) {
                dataList = new ArrayList<>();
                dataList.add(people);
                dataList.add(golds);
            } else {
                dataList = conquestMap.get(city);
                dataList.set(0, dataList.get(0) + people);
                dataList.set(1, dataList.get(1) + golds);
            }
            conquestMap.put(city, dataList);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("End")) {
            String command = input.split("=>")[0];
            String city = input.split("=>")[1];

            dataList = conquestMap.get(city);
            int currentPeople = dataList.get(0);
            int currentGold = dataList.get(1);

            if (command.equals("Plunder")) {
                int people = Integer.parseInt(input.split("=>")[2]);
                int gold = Integer.parseInt(input.split("=>")[3]);

                currentPeople -= people;
                currentGold -= gold;

                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, currentGold, currentPeople);

                if (currentPeople <= 0 || currentGold <= 0) {
                    System.out.printf("%s has been wiped off the map!", city);
                    conquestMap.remove(city);
                }

            } else if (command.equals("Prosper")) {
                int gold = Integer.parseInt(input.split("=>")[2]);

                if (gold <= 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    currentGold += gold;
                    dataList.set(1, currentGold);
                    conquestMap.put(city, dataList);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, city, currentGold);
                }
            }
            countCity = conquestMap.entrySet().size();
            input = scanner.nextLine();
        }

        if (conquestMap.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", countCity);
            for (Map.Entry<String, List<Integer>> entry : conquestMap.entrySet()) {
                System.out.println(entry.getKey() + " -> ");

                for (int i = 0; i < entry.getValue().size(); i++) {
                    if (i == 0) {
                        System.out.printf("Population: %d citizens, ", entry.getValue().get(i));
                    } else if (i == 1) {
                        System.out.printf("Gold: %d kg, ", entry.getValue().get(i));
                    }
                }
                System.out.println();
            }
        }
    }
}
