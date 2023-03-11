package FinalExams;

import java.util.*;
import java.util.stream.Collectors;

public class PlantDiscovery_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> plantsInfo = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            double counter = 0.00;
            double rating = 0.00;

            String name = input.split("<->")[0];
            double rarity = Double.parseDouble(input.split("<->")[1]);
            if (plantsInfo.containsKey(name)) {
                List<Double> plantsList = plantsInfo.get(name);
                plantsList = plantsInfo.get(name);
                plantsList.set(0, rarity);
                plantsInfo.put(name, plantsList);
            } else {
                List<Double> plantsList = new ArrayList<>();
                plantsList.add(rarity);
                plantsList.add(rating);
                plantsList.add(counter);
                plantsInfo.put(name, plantsList);
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("Exhibition")) {

            String[] info = command.split("[: -]+");
            String currentPlant = info[1];
            List<Double> plantsList = plantsInfo.get(currentPlant);

            if (!plantsInfo.containsKey(currentPlant)) {
                System.out.println("error");
            } else {
                switch (info[0]) {

                    case "Rate":
                        double rating = Double.parseDouble(info[2]);
                        double counter = plantsList.get(2);
                        double currentRating = plantsList.get(1);

                        currentRating += rating;
                        counter++;

                        plantsList.set(1, currentRating);
                        plantsList.set(2, counter);
                        plantsInfo.put(currentPlant, plantsList);
                        break;

                    case "Update":
                        double rarity = Double.parseDouble(info[2]);

                        plantsList.set(0, rarity);
                        plantsInfo.put(currentPlant, plantsList);
                        break;

                    case "Reset":
                        plantsList.set(1, 0.00);
                        plantsInfo.put(currentPlant, plantsList);
                        break;

                    default:
                        System.out.println("error");

                }
            }
            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<Double>> entry : plantsInfo.entrySet()) {
            double counter = entry.getValue().get(2);
            double rating = entry.getValue().get(1);
            double avrRating = entry.getValue().get(1) / entry.getValue().get(2);
            if (counter > 0) {
                List<Double> plantsList = plantsInfo.get(entry.getKey());
                plantsList.set(1, avrRating);
                plantsInfo.put(entry.getKey(), plantsList);
            }
        }
        System.out.println("Plants for the exhibition:");

        plantsInfo.forEach((key, value) ->
                System.out.printf("- %s; Rarity: %.0f; Rating: %.2f%n", key, value.get(0), value.get(1)));

//        System.out.println("Plants for the exhibition:");
//        for (Map.Entry<String, List<Double>> entry : plantsInfo.entrySet()) {
//            System.out.printf("- %s; ", entry.getKey());
//
//            for (int i = 0; i < entry.getValue().size(); i++) {
//                if (i == 0) {
//                    System.out.printf("Rarity: %.0f; ", entry.getValue().get(0));
//                } else if (i == 1) {
//                    System.out.printf("Rating: %.2f%n", entry.getValue().get(1));
//                }
//            }
//        }

    }
}
