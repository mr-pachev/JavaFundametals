import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String stops = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Travel")) {
            String command = input.split("\\:")[0];

            switch (command) {
                case "Add Stop":
                    int indexAdd = Integer.parseInt(input.split("\\:")[1]);
                    String stopAdd = input.split("\\:")[2];

                    if (isValid(stops, indexAdd)) {
                        String startPart = stops.substring(0, indexAdd);
                        String endPart = stops.substring(indexAdd);
                        stops = "";
                        stops = stops.concat(startPart).concat(stopAdd).concat(endPart);
                    }
                    System.out.println(stops);
                    break;

                case "Remove Stop":
                    int startIndexRemove = Integer.parseInt(input.split("\\:")[1]);
                    int endIndexRemove = Integer.parseInt(input.split("\\:")[2]);

                    if (isValid(stops, startIndexRemove) && isValid(stops, endIndexRemove)) {
                        String firstPart = stops.substring(0, startIndexRemove);
                        String secondPart = stops.substring(endIndexRemove + 1);
                        stops = "";
                        stops = stops.concat(firstPart).concat(secondPart);
                    }
                    System.out.println(stops);
                    break;

                case "Switch":
                    String oldString = input.split("\\:")[1];
                    String newString = input.split("\\:")[2];

                    if (stops.contains(oldString)) {
                        int startInt = stops.indexOf(oldString);
                        int endInt = startInt + oldString.length();

                        String first = stops.substring(0, startInt);
                        String second = stops.substring(endInt);
                        stops = "";
                        stops = stops.concat(first).concat(newString).concat(second);
                    }
                    System.out.println(stops);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", stops);

    }

    public static boolean isValid(String stops, int index) {
        return index >= 0 && index < stops.length();
    }
}
