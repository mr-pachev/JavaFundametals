package FinalExamPreparation;

import java.util.*;

public class NeedForSpeedIII_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> carMap = new LinkedHashMap<>();


        for (int i = 1; i <= n; i++) {
            List<Integer> carDataList = new ArrayList<>();
            String inputCarInfo = scanner.nextLine();
            String carModel = inputCarInfo.split("\\|")[0];
            int mileage = Integer.parseInt(inputCarInfo.split("\\|")[1]);
            int fuel = Integer.parseInt(inputCarInfo.split("\\|")[2]);
            carDataList.add(mileage);
            carDataList.add(fuel);
            carMap.put(carModel, carDataList);
        }

        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String car = input.split(" : ")[1];
            int currentMileage = carMap.get(car).get(0); // текущ пробег на текуща кола
            int currentFuel = carMap.get(car).get(1); //текущо гориво на текущата кола

            if (input.contains("Drive")) {

                int distance = Integer.parseInt(input.split(" : ")[2]);
                int fuel = Integer.parseInt(input.split(" : ")[3]);

                if (fuel < currentFuel) {
                    carMap.get(car).set(1, currentFuel - fuel); //carMap.get(car).->това е value на мапа, което е лист елементите му се достъпват с get
                    carMap.get(car).set(0, currentMileage + distance);

                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                } else {
                    System.out.println("Not enough fuel to make that ride");
                }

                if(currentMileage + distance >= 100000){
                    System.out.printf("Time to sell the %s!%n", car);
                    carMap.remove(car);
                }

            } else if (input.contains("Refuel")) {
                String carRefuel = input.split(" : ")[1];
                int fuelRefuel = Integer.parseInt(input.split(" : ")[2]);
                int diff = 75 - currentFuel;

                currentFuel = currentFuel + fuelRefuel;

                if(currentFuel > 75){
                    currentFuel = 75;
                }else {
                    diff = fuelRefuel;
                }
                System.out.printf("%s refueled with %d liters%n", car, diff);
                carMap.get(car).set(1, currentFuel);

            } else if (input.contains("Revert")) {
                String carRevert = input.split(" : ")[1];
                int kilometers = Integer.parseInt(input.split(" : ")[2]);
                currentMileage = currentMileage - kilometers;

                if(currentMileage < 10000){
                    carMap.get(car).set(0, 10000);
                }else {
                    carMap.get(car).set(0, currentMileage);
                    System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                }
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<Integer>> entry : carMap.entrySet()) {
            String car = entry.getKey();
            int mileage = entry.getValue().get(0);
            int fuel = entry.getValue().get(1);
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", car, mileage, fuel);
        }

    }
}
