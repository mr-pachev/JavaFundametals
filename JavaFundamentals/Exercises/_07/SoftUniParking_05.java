package Exercises._07;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> driverIDMap = new LinkedHashMap<>();

        String driverName = "";
        String licensePlateNumber = "";


        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String command = input.split(" ")[0];

            switch (command) {

                case "register":
                    driverName = input.split(" ")[1];
                    licensePlateNumber = input.split(" ")[2];
                    if (!driverIDMap.containsKey(driverName)) {
                        driverIDMap.put(driverName, licensePlateNumber);
                        System.out.printf("%s registered %s successfully%n", driverName, licensePlateNumber);
                    } else {
                        String currentLicensePlateNumber = driverIDMap.get(driverName);
                        System.out.printf("ERROR: already registered with plate number %s%n", licensePlateNumber);
                    }
                    break;

                case "unregister":
                    driverName = input.split(" ")[1];

                    if (!driverIDMap.containsKey(driverName)) {
                        System.out.printf("ERROR: user %s not found%n", driverName);
                    } else {
                        System.out.printf("%s unregistered successfully%n", driverName);
                        driverIDMap.remove(driverName);
                    }
                    break;
            }

        }
        for (Map.Entry<String, String> entry : driverIDMap.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }

    }
}
