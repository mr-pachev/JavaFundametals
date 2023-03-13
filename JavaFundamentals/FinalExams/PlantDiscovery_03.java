package FinalExams;

import java.util.*;
import java.util.stream.Collectors;

public class PlantDiscovery_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());                     //брой разстения с тяхната рядкост

        Map<String, List<Double>> plantMap = new LinkedHashMap<>();       //речник съдържащ разстенията
        List<Double> plantInfoList = new ArrayList<>();

        for (int currentPlant = 1; currentPlant <= n; currentPlant++) {
            String[] inputArr = scanner.nextLine().split("<->");    //масив от стрингове с входните данни
            String plantName = inputArr[0];                               //име на текущото разстение
            double rarity = Double.parseDouble(inputArr[1]);              //рядкост на текущото разстение

            if (!plantMap.containsKey(plantName)) {                       //проверка дали даденото разстение не е в речника
                plantInfoList = new ArrayList<>();
                plantInfoList.add(rarity);
                plantInfoList.add(0.00);                                  //добавка и на рейтинг
            } else {                                                      //ъпдейт на рядкостта на съществуващото разстение
                plantInfoList = plantMap.get(plantName);
                plantInfoList.set(0, rarity);
            }
            plantMap.put(plantName, plantInfoList);                       //пълнене на рачника
        }

        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {
            String[] inputArr = input.split("[: -]+");
            String command = inputArr[0];                                 //команда
            String plantName = inputArr[1];                               //име на разстението
            plantInfoList = plantMap.get(plantName);

            if (!plantMap.containsKey(plantName)) {
                System.out.println("error");
                input = scanner.nextLine();
                continue;
            }
            switch (command) {
                case "Rate":
                    double rating = Double.parseDouble(inputArr[2]);         //нова оценка за разстението
                    double currentRating = plantMap.get(plantName).get(1);   //текуща оценка на разстението

                    if (currentRating > 0) {                                  //проверка дали има вече оценка за изчисляване на средна стойност
                        plantInfoList.set(1, (currentRating + rating) / 2);  //добявяне и намиране на средната оценка на разстението
                    } else {
                        plantInfoList.set(1, currentRating + rating);
                    }
                    plantMap.put(plantName, plantInfoList);
                    break;
                case "Update":
                    double rarity = Double.parseDouble(inputArr[2]);
                    plantInfoList.set(0, rarity);
                    plantMap.put(plantName, plantInfoList);
                    break;
                case "Reset":
                    plantInfoList.set(1, 0.00);
                    plantMap.put(plantName, plantInfoList);
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");

        plantMap.forEach((key, value) ->
                System.out.printf("- %s; Rarity: %.0f; Rating: %.2f%n", key, value.get(0), value.get(1)));

    }
}
