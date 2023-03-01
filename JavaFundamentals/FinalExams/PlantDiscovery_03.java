package FinalExams;

import java.util.*;

public class PlantDiscovery_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> plantsInfo = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            double counter = 0;
            double rating = 0.00;

            List<Double> plantsList = new ArrayList<>();
            String name = input.split("<->")[0];
            double rarity = Double.parseDouble(input.split("<->")[1]);
            plantsList.add(rarity);
            plantsList.add(rating);
            plantsList.add(counter);
            plantsInfo.put(name, plantsList);
        }

        String command = scanner.nextLine();

        while (!command.contains("Exhibition")) {

            String info = command.split(":\\s+")[1];
            String currentPlant = info.split("\\s+\\-\\s+")[0];

            if (!plantsInfo.containsKey(currentPlant)) {
                System.out.println("error");
                command = scanner.nextLine();
                continue;
            }

            switch (command.split(":\\s+")[0]) {


                case "Rate": {
                    double rating = Double.parseDouble(info.split("\\s+\\-\\s+")[1]);

                    List<Double> plantsList = plantsInfo.get(currentPlant);
                    double counter = plantsList.get(2);
                    counter++;

                    plantsList.set(1, plantsList.get(1) + rating);
                    plantsList.set(2, counter);
                    plantsInfo.put(currentPlant, plantsList);
                    break;
                }
                case "Update": {
                    double rarity = Double.parseDouble(info.split("\\s+\\-\\s+")[1]);

                    List<Double> plantsList = plantsInfo.get(currentPlant);
                    plantsList.set(0, rarity);
                    plantsInfo.put(currentPlant, plantsList);
                    break;
                }
                case "Reset": {
                    List<Double> plantsList = plantsInfo.get(info);
                    plantsList.set(1, 0.00);
                    plantsInfo.put(info, plantsList);
                    break;
                }
            }
            command = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");

        plantsInfo.forEach((key, value) ->
                System.out.printf("- %s; Rarity: %.0f; Rating: %.2f%n", key, value.get(0), value.get(1) / value.get(2)));


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
