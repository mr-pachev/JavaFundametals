package Exersice_06_VehicleCatalogue_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstInput = scanner.nextLine();
        List<Vehicle> vehicleList = new ArrayList<>();

        int counterCar = 0;
        double hpCar = 0;
        int counterTruck = 0;
        double hpTruck = 0;

        while (!firstInput.equals("End")) {
            String type = firstInput.split(" ")[0];
            String model = firstInput.split(" ")[1];
            String color = firstInput.split(" ")[2];
            double horsepower = Double.parseDouble(firstInput.split(" ")[3]);

            Vehicle vehicle = new Vehicle(type, model, color, horsepower);
            vehicleList.add(vehicle);

            if (type.equals("car")){
                counterCar++;
                hpCar += horsepower;
            }else if (type.equals("truck")){
                counterTruck++;
                hpTruck += horsepower;
            }

            firstInput = scanner.nextLine();
        }
        String secondInput = scanner.nextLine();

        while (!secondInput.equals("Close the Catalogue")) {
            for (Vehicle items : vehicleList) {
                if (secondInput.equals(items.getModel())) {
                    System.out.println(items.toString());
                }
            }
            secondInput = scanner.nextLine();
        }
        double averageCar = hpCar / counterCar;
        double averageTruck = hpTruck / counterTruck;
        if (averageCar == 0 || counterCar == 0) {
            System.out.println("Cars have average horsepower of: 0.00.");
        }else {
            System.out.printf("Cars have average horsepower of: %.2f.%n", averageCar);
        }

        if (averageTruck == 0 || counterTruck == 0) {
            System.out.println("Trucks have average horsepower of: 0.00.");
        }else {
            System.out.printf("Trucks have average horsepower of: %.2f.%n", averageTruck);
        }



    }
}
