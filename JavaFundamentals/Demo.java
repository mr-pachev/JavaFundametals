import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPlants = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> plantaMap = new LinkedHashMap<>();

        for (int currentPlant = 1; currentPlant <= countPlants; currentPlant++) {
            List<Double> plantsInfo = new ArrayList<>();
            String input = scanner.nextLine();

            String plantName = input.split("<->")[0];
            double rarity = Double.parseDouble(input.split("<->")[1]);

            if (plantaMap.containsKey(plantName)) {
                plantsInfo = plantaMap.get(plantName);
                plantsInfo.set(0, rarity);
            } else {
                plantsInfo.add(rarity);
                plantsInfo.add(0.0);
            }

            plantaMap.put(plantName, plantsInfo);
        }

        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {
            String command = input.split("[: -]")[0];
            String name = input.split("[:\\s-]+")[1];

            if (!plantaMap.containsKey(name)) {
                System.out.println("error");
            } else {
                List<Double> plantsInfo = plantaMap.get(name);

                switch (command) {
                    case "Rate":
                        double rating = Double.parseDouble(input.split("[:\\s-]+")[2]);
                        double avr = plantsInfo.get(1);

                        if (avr > 0) {
                            plantsInfo.set(1, (rating + avr) / 2);
                        }else {
                            plantsInfo.set(1, rating);
                        }

                        plantaMap.put(name, plantsInfo);
                        break;

                    case "Update":
                        double newRarity = Double.parseDouble(input.split("[:\\s-]+")[2]);
                        plantsInfo.set(0, newRarity);
                        plantaMap.put(name, plantsInfo);
                        break;

                    case "Reset":
                        plantsInfo.set(1, 0.0);
                        plantaMap.put(name, plantsInfo);
                        break;
                }
            }

            input = scanner.nextLine();
        }


        System.out.println("Plants for the exhibition:");

        for (Map.Entry<String, List<Double>> entry : plantaMap.entrySet()) {
            System.out.print("- " + entry.getKey() + "; ");
            for (int i = 0; i < entry.getValue().size() ; i++) {
                if (i == 0){
                    System.out.printf("Rarity: %.0f; ", entry.getValue().get(i));
                }else if (i == 1){
                    System.out.printf("Rating: %.2f%n", entry.getValue().get(i));
                }
            }
        }


    }
}
