package FinalExams;

import java.util.Scanner;

public class WorldTour_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destinations = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.contains("Travel")) {

            switch (command.split(":")[0]) {
                case "Add Stop": {
                    int index = Integer.parseInt(command.split(":")[1]);
                    String stop = command.split(":")[2];

                    if (isValidIndex(destinations, index)) {
                        String firstPart = destinations.substring(0, index);
                        String secondPart = destinations.substring(index);

                        destinations = firstPart.concat(stop).concat(secondPart);
                    }
                    break;
                }
                case "Remove Stop": {
                    int startIndex = Integer.parseInt(command.split(":")[1]);
                    int endIndex = Integer.parseInt(command.split(":")[2]);

                    if (isValidIndex(destinations, startIndex) && isValidIndex(destinations, endIndex)) {

                        String firstPart = destinations.substring(0, startIndex);
                        String secondPart = destinations.substring(endIndex + 1);

                        destinations = firstPart.concat(secondPart);
                    }
                    break;
                }
                case "Switch": {
                    String oldString = command.split(":")[1];
                    String newString = command.split(":")[2];

                    destinations = destinations.replace(oldString, newString);
                    break;
                }
            }
            System.out.println(destinations);
            command = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s", destinations);
    }

    public static boolean isValidIndex(String destinations, int index) {
        return index >= 0 && index <= destinations.length() - 1;
    }
}
