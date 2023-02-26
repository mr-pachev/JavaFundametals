package FinalExams;

import java.util.*;

public class NeedForSpeed_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n =Integer.parseInt(scanner.nextLine());
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

        while (!input.equals("Stop")){
            String command = input.split("\\s+:\\s+")[0];

            switch (command){
                case "Drive":{
                    String modelDrive = input.split("\\s+:\\s+")[1];
                    double mileageDrive = Double.parseDouble(input.split("\\s+:\\s+")[2]);
                    double fuelDrive = Double.parseDouble(input.split("\\s+:\\s+")[3]);

                    List<Double> cardList = carsMap.get(modelDrive);
                    double currentFuel = cardList.get(1);  //текущо количество гориво за даденият автомобил
                    double currentMileage = cardList.get(0);
                    if (currentFuel < fuelDrive){
                        System.out.println("Not enough fuel to make that ride");
                    }else {
                        currentFuel -= fuelDrive;
                        currentMileage += mileageDrive;

                        System.out.printf("%s driven for %.0f kilometers. %.0f liters of fuel consumed.%n",modelDrive , mileageDrive, fuelDrive);

                        if (currentMileage >= 100000.0){
                            System.out.println("Time to sell the {car}!");

                            carsMap.remove(modelDrive);
                        }else {
                            cardList.set(0, currentMileage);
                            cardList.set(1, currentFuel);
                            carsMap.put(modelDrive, cardList);

                        }

                    }

                    break;
                }
                case "Refuel":{
                    String modelRefuel = input.split("\\s+:\\s+")[1];
                    double fuelRefuel = Double.parseDouble(input.split("\\s+:\\s+")[2]);
                    double usedFuel = fuelRefuel;
                    List<Double> cardList = carsMap.get(modelRefuel);
                    double currentFuel = cardList.get(1);  //текущо количество гориво за даденият автомобил

                    if (currentFuel + fuelRefuel > 75){
                        usedFuel = 75 - fuelRefuel;
                        currentFuel = 75.0;

                        cardList.set(1, currentFuel);
                    }

                    carsMap.put(modelRefuel, cardList);
                        System.out.printf("%s refueled with %.0f liters", modelRefuel, usedFuel);

                    break;
                }
                case "Revert":{
                    break;
                }

            }

            input = scanner.nextLine();
        }
    }
}
