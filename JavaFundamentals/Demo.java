import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> travelStops = Arrays.stream(input
                .split("[\\:-]+")).collect(Collectors.toList());

        String symbolOne = input.split("[A-Z][a-z]+")[1];
        String symbolTwo = input.split("[A-Z][a-z]+")[2];

        input = scanner.nextLine();

        while (!input.equals("Travel")){
            String command = input.split("[\\: ]+")[0];

            switch (command){
                case "Add":
                    int indexAdd = Integer.parseInt(input.split("[\\: ]+")[1]);
                    String stopAdd = input.split("[\\: ]+")[2];


                    break;
                case "Remove":
                    break;
                case "Switch":
                    break;
            }


            input = scanner.nextLine();
        }

    }
}
