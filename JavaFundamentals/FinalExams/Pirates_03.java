package FinalExams;

import java.util.*;

public class Pirates_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<Integer>> citiesMap = new LinkedHashMap<>();

        while (!input.contains("Sail")) {
            String cityName = input.split("\\|\\|")[0];
            int population = Integer.parseInt(input.split("\\|\\|")[1]);
            int gold = Integer.parseInt(input.split("\\|\\|")[2]);

            if (citiesMap.containsKey(cityName)) {
                List<Integer> cityDataList = citiesMap.get(cityName);
                int currentPopulation = cityDataList.get(0);
                int currentGold = cityDataList.get(1);
                cityDataList.set(0, currentPopulation + population);
                cityDataList.set(1, currentGold + gold);
                citiesMap.put(cityName, cityDataList);
            } else {
                List<Integer> cityDataList = new ArrayList<>();
                cityDataList.add(population);
                cityDataList.add(gold);
                citiesMap.put(cityName, cityDataList);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.contains("End")) {
            String command = input.split("\\=\\>")[0];

            switch (command) {
                case "Plunder": {
                    String cityName = input.split("=>")[1];
                    int populationPlunder = Integer.parseInt(input.split("\\=\\>")[2]);
                    int goldPlunder = Integer.parseInt(input.split("\\=\\>")[3]);

                    List<Integer> cityDataList = citiesMap.get(cityName);
                    int currentPopulation = cityDataList.get(0);
                    int currentGold = cityDataList.get(1);

                    if (currentPopulation - populationPlunder <= 0 || currentGold - goldPlunder <= 0) {
                        citiesMap.remove(cityName);
                        System.out.printf("%s has been wiped off the map!%n", cityName);
                    } else {
                        cityDataList.set(0, currentPopulation - populationPlunder);
                        cityDataList.set(1, currentGold - goldPlunder);
                        citiesMap.put(cityName, cityDataList);
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", cityName, goldPlunder, populationPlunder);
                    }
                    break;
                }
                case "Prosper": {
                    String cityName = input.split("=>")[1];
                    int goldProsper = Integer.parseInt(input.split("\\=\\>")[2]);

                    List<Integer> cityDataList = citiesMap.get(cityName);
                    int currentGold = cityDataList.get(1);

                    if (goldProsper <= 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        cityDataList.set(1, currentGold + goldProsper);
                        citiesMap.put(cityName, cityDataList);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldProsper, cityName, currentGold + goldProsper);
                    }
                    break;
                }
            }
            input = scanner.nextLine();
        }
    }
}
