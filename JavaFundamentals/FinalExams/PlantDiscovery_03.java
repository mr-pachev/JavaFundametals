package FinalExams;

import java.util.*;

public class PlantDiscovery_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> plantsInfo = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            List<Double> plantsList = new ArrayList<>();
            String name = input.split("<->")[0];
            double rarity = Double.parseDouble(input.split("<->")[1]);
            plantsList.add(rarity);
            plantsInfo.put(name, plantsList);
        }

        String command = scanner.nextLine();

        while (!command.contains("Exhibition")) {

            String info = command.split(": ")[1];
            switch (command.split(": ")[0]) {

                case "Rate": {
                    String currentPlant = info.split(" - ")[0];
                    double rating = Double.parseDouble(info.split(" - ")[1]);

                    if (isExist(currentPlant, plantsInfo)) {
                        List<Double> plantsList = plantsInfo.get(currentPlant);

                        plantsList.add(rating);
                        plantsInfo.put(currentPlant, plantsList);
                    } else {
                        System.out.println("error");
                    }
                    break;
                }
                case "Update": {
                    String currentPlant = info.split(" - ")[0];
                    double rarity = Integer.parseInt(info.split(" - ")[1]);

                    if (isExist(currentPlant, plantsInfo)) {
                        List<Double> plantsList = plantsInfo.get(currentPlant);
                        plantsList.set(0, rarity);
                        plantsInfo.put(currentPlant, plantsList);
                    } else {
                        System.out.println("error");
                    }
                    break;
                }
                case "Reset": {

                    if (isExist(info, plantsInfo)) {
                        List<Double> plantsList = plantsInfo.get(info);
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

        for (Map.Entry<String, List<Double>> entry : plantsInfo.entrySet()) {

            for (Double s : entry.getValue()) {
                if (entry.getValue().size() > 1) {
                    List<Double> average = entry.getValue();
                    double rarity = entry.getValue().get(0);
                    average.remove(0);
                    double avr = getAverage(average);
                    List<Double> newList = new ArrayList<>();
                    newList.add(rarity);
                    newList.add(avr);
                    plantsInfo.put(entry.getKey(), newList);
                    break;
                }else {
                    List<Double> newList = new ArrayList<>();
                    double rarity = entry.getValue().get(0);
                    newList.add(rarity);
                    newList.add(0.00);
                    plantsInfo.put(entry.getKey(), newList);
                }
            }
        }

        for (Map.Entry<String, List<Double>> entry : plantsInfo.entrySet()) {
            System.out.printf("- %s; ", entry.getKey());

            for (int i = 0; i < entry.getValue().size(); i++) {
                if (i == 0) {
                    System.out.printf("Rarity: %.0f; ", entry.getValue().get(0));
                } else if (i == 1) {
                    System.out.printf("Rating: %.2f%n", entry.getValue().get(1));
                }
            }
        }

    }

    public static boolean isExist(String plant, Map<String, List<Double>> plantsMap) {
        return plantsMap.containsKey(plant);
    }

    //метод за намиране на средна стойност на елевентите от List<Integer>
    private static double getAverage(List<Double> list) {
        DoubleSummaryStatistics stats = list.stream()
                .mapToDouble(Double::intValue)
                .summaryStatistics();
        return stats.getAverage();
    }
}
