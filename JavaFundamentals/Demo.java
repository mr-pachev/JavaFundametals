import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> treasureList = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Yohoho!")){
            String command = input.split(" ")[0];

            if (command.equals("Loot")){

            }else if (command.equals("Drop")){

            }else if (command.equals("Steal")){

            }



            input = scanner.nextLine();
        }

    }
}
