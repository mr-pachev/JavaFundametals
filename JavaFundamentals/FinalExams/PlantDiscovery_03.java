package FinalExams;

import java.util.*;

public class PlantDiscovery_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> plantsInfo = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            List<Integer> plantsList = new ArrayList<>();
            String name = input.split("<->")[0];
            int rarity = Integer.parseInt(input.split("<->")[1]);
            plantsList.add(rarity);
            plantsInfo.put(name, plantsList);
        }

        String command = scanner.nextLine();

        while (!command.contains("Exhibition")) {

            String info = command.split(": ")[1];
            switch (command.split(": ")[0]) {

                case "Rate": {
                    String currentPlant = info.split(" - ")[0];
                    int rating = Integer.parseInt(info.split(" - ")[1]);

                    if (isExist(currentPlant, plantsInfo)) {
                        List<Integer> plantsList = plantsInfo.get(currentPlant);

                        plantsList.add(rating);
                        plantsInfo.put(currentPlant, plantsList);
                    } else {
                        System.out.println("error");
                    }
                    break;
                }
                case "Update": {
                    String currentPlant = info.split(" - ")[0];
                    int rarity = Integer.parseInt(info.split(" - ")[1]);

                    if (isExist(currentPlant, plantsInfo)) {
                        List<Integer> plantsList = plantsInfo.get(currentPlant);
                        plantsList.set(0, rarity);
                        plantsInfo.put(currentPlant, plantsList);
                    } else {
                        System.out.println("error");
                    }
                    break;
                }
                case "Reset": {

                    if (isExist(info, plantsInfo)) {
                        List<Integer> plantsList = plantsInfo.get(info);
                        plantsList.remove(1);
                        plantsInfo.put(info, plantsList);
                    } else {
                        System.out.println("error");
                    }
                    break;
                }
            }
            command = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");

        for (Map.Entry<String, List<Integer>> entry : plantsInfo.entrySet()) {
            System.out.printf("- %s; ", entry.getKey());

            for (int i = 0; i < entry.getValue().size(); i++) {
                if (entry.getValue().size() == 1) {
                    System.out.printf("Rarity: %d; Rating: 0.00%n", entry.getValue().get(0));
                } else {
                    List<Integer> average = entry.getValue();
                    int rarity = entry.getValue().get(0);
                    average.remove(0);
                    double avr = getAverage(average);
                    System.out.printf("Rarity: %d; Rating: %.2f%n", rarity, avr);
                    break;
                }
            }
        }


    }

    public static boolean isExist(String plant, Map<String, List<Integer>> plantsMap) {
        return plantsMap.containsKey(plant);
    }

    //метод за намиране на средна стойност на елевентите от List<Integer>
    private static double getAverage(List<Integer> list) {
        IntSummaryStatistics stats = list.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        return stats.getAverage();
    }
}
