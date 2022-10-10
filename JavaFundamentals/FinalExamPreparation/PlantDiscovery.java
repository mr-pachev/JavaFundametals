package FinalExamPreparation;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> plantsMap = new LinkedHashMap<>();
        List<Double> valueList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            valueList = new ArrayList<>();
            String incoming = scanner.nextLine();
            String plant = incoming.split("<->")[0]; //растение
            double rarity = Double.parseDouble(incoming.split("<->")[1]); //рядкост
            double rating = 0.0;
            double counter = 0.0;
            valueList.add(rarity);
            valueList.add(rating);
            valueList.add(counter);

            plantsMap.put(plant, valueList);
        }
        String command = scanner.nextLine();

        while (!command.equals("Exhibition")) {
            String commandName = command.split(": ")[0]; //команда
            String current = command.split(": ")[1];
            String plantName = current.split(" - ")[0]; //растение

            if (!plantsMap.containsKey(plantName)) { //проверка дали растението се съдържа в мапа
                System.out.println("error");
            }

            if (commandName.contains("Rate")) {
                valueList = plantsMap.get(plantName); //взимане на листа за текущия key на мапа
                double counter = valueList.get(2);
                counter++;
                double rating = Double.parseDouble(current.split(" - ")[1]);
                double currentRating = valueList.get(1); //взимане на индекса, на които се намира рейтинга в списъка
                currentRating += rating;
                plantsMap.get(plantName).set(2, counter);
                plantsMap.get(plantName).set(1, currentRating);

            } else if (commandName.contains("Update")) {
                double rarityPlant = Double.parseDouble(current.split(" - ")[1]); //рядкост
                plantsMap.get(plantName).set(0, rarityPlant);


            } else if (commandName.contains("Reset")) {
                plantsMap.get(plantName).set(1, 0.0);
            }

            command = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");

        for (Map.Entry<String, List<Double>> entry : plantsMap.entrySet()) {
            if (entry.getValue().get(2) > 1) {
                plantsMap.get(entry.getKey()).set(1, entry.getValue().get(1) / entry.getValue().get(2));
            }
        }
        plantsMap.forEach((key, value) ->
                System.out.printf("- %s; Rarity: %.0f; Rating: %.2f%n", key, value.get(0), value.get(1)));

    }
}
