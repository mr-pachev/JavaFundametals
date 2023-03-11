package FinalExams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plantRarityMap = new HashMap<>();          //речник с разстението и рядкостта му
        Map<String, Double> rateMap = new HashMap<>();                  //речник с разстението и оценката му

        for (int i = 0; i < n; i++) {                                   //пълнене на речниците
            String[] tokens = scanner.nextLine().split("<->");
            String plant = tokens[0];                                   //име на разстението
            int rarity = Integer.parseInt(tokens[1]);                   //рядкост на разстението

            plantRarityMap.putIfAbsent(plant, 0);
            rateMap.putIfAbsent(plant, 0.0);

            //K -> plant  ------   V -> rarity
            plantRarityMap.put(plant, rarity);
//            if (plantRarityMap.get(plant) < rarity) {
//            }

//            plantRarityMap.put(plant, rarity);
        }

        String inputLine = scanner.nextLine();                   //входни данни

        while (!inputLine.equals("Exhibition")) {
            String[] tokens = inputLine.split("[: -]+");   //масив с входните данни
            String command = tokens[0];                          //команда
            String plant = tokens[1];                            //име на конкретното разстение

            if (!rateMap.containsKey(plant)) {
                System.out.println("error");
            } else {
                switch (command) {
                    case "Rate":
                        double currentRate = Double.parseDouble(tokens[2]);           //рейтинга от входните данни
                        if (rateMap.get(plant) == 0) {                                //проверка дали рейтинга за това разстение е нула (още не е оценено)
                            rateMap.put(plant, currentRate);
                        } else {
                            double newRate = (rateMap.get(plant) + currentRate) / 2;  //добавяне на текущатата оценка към досегашните и намиране на средната им стойност
                            rateMap.put(plant, newRate);
                        }
                        break;
                    case "Update":
                        int newRarity = Integer.parseInt(tokens[2]);

                        plantRarityMap.put(plant, newRarity);
                        break;
                    case "Reset":
                        rateMap.put(plant, 0.0);
                        break;
                    default:
                        System.out.println("error");
                }
            }

            inputLine = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        plantRarityMap.entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                            entry.getKey(), entry.getValue(), rateMap.get(entry.getKey()));
                });
    }
}
