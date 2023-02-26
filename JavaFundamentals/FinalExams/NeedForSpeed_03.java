package FinalExams;

import java.util.*;

public class NeedForSpeed_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> carsMap = new LinkedHashMap<>();

        for (int car = 1; car <= n; car++) {
            String input = scanner.nextLine();
            String model = input.split("\\|")[0];
            double mileage = Double.parseDouble(input.split("\\|")[1]);
            double fuel = Double.parseDouble(input.split("\\|")[2]);

            List<Double> carInfo = new ArrayList<>();
            carInfo.add(mileage);
            carInfo.add(fuel);
            carsMap.put(model, carInfo);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String command = input.split("\\s+:\\s+")[0];

            switch (command) {
                case "Drive": {
                    String modelDrive = input.split("\\s+:\\s+")[1];
                    double mileageDrive = Double.parseDouble(input.split("\\s+:\\s+")[2]);
                    double fuelDrive = Double.parseDouble(input.split("\\s+:\\s+")[3]);

                    List<Double> cardList = carsMap.get(modelDrive);
                    double currentFuel = cardList.get(1);  //текущо количество гориво за даденият автомобил
                    double currentMileage = cardList.get(0);
                    if (currentFuel < fuelDrive) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        currentFuel -= fuelDrive;
                        currentMileage += mileageDrive;
                        System.out.printf("%s driven for %.0f kilometers. %.0f liters of fuel consumed.%n", modelDrive, mileageDrive, fuelDrive);

                        if (currentMileage >= 100000.0) {
                            System.out.printf("Time to sell the %s!%n", modelDrive);
                            carsMap.remove(modelDrive);
                        } else {
                            cardList.set(0, currentMileage);
                            cardList.set(1, currentFuel);
                            carsMap.put(modelDrive, cardList);
                        }
                    }
                    break;
                }
                case "Refuel": {
                    String modelRefuel = input.split("\\s+:\\s+")[1];
                    double fuelRefuel = Double.parseDouble(input.split("\\s+:\\s+")[2]);
                    double usedFuel = fuelRefuel;
                    List<Double> cardList = carsMap.get(modelRefuel);
                    double currentFuel = cardList.get(1);  //текущо количество гориво за даденият автомобил

                    if (currentFuel + fuelRefuel > 75) {
                        usedFuel = 75 - currentFuel;
                        currentFuel = 75.0;
                        cardList.set(1, currentFuel);
                    }else {
                        cardList.set(1, fuelRefuel + currentFuel);
                    }
                    carsMap.put(modelRefuel, cardList);
                    System.out.printf("%s refueled with %.0f liters%n", modelRefuel, usedFuel);
                    break;
                }
                case "Revert": {
                    String modelRevert = input.split("\\s+:\\s+")[1];
                    double mileageRevert = Double.parseDouble(input.split("\\s+:\\s+")[2]);
                    List<Double> cardList = carsMap.get(modelRevert);
                    double currentMileage = cardList.get(0);  //текущи километри за даденият автомобил

                    if (currentMileage - mileageRevert < 10000) {
                        cardList.set(0, 10000.0);
                    } else {
                        cardList.set(0, currentMileage - mileageRevert);
                        System.out.printf("%s mileage decreased by %.0f kilometers%n", modelRevert, mileageRevert);
                    }
                    carsMap.put(modelRevert, cardList);
                    break;
                }
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<Double>> entry : carsMap.entrySet()) {
            System.out.printf("%s -> ", entry.getKey());

            for (int i = 0; i < entry.getValue().size(); i++) {
                if (i == 0) {
                    System.out.printf("Mileage: %.0f kms, ", entry.getValue().get(0));
                } else if (i == 1) {
                    System.out.printf("Fuel in the tank: %.0f lt.%n", entry.getValue().get(1));
                }
            }
        }
    }
}
