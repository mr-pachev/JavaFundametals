import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        ;

        String input = scanner.nextLine();

        while (!input.equals("Craft!")) {
            String command = input.split(" - ")[0];
            String element = input.split(" - ")[1];

            switch (command) {
                case "Collect":
                    if (!inputList.contains(element)) {
                        inputList.add(element);
                    }
                    break;
                case "Drop":
                    for (int i = 0; i < inputList.size(); i++) {
                        String current = inputList.get(i);

                        if (element.equals(current)){
                            inputList.remove(i);
                            break;
                        }
                    }
                    break;
                case "Combine Items":
                    String oldElement = element.split("\\:")[0];
                    String newElement = element.split("\\:")[1];
                    if (inputList.contains(oldElement)) {
                        int startIndex = inputList.lastIndexOf(oldElement);
                        inputList.add(startIndex, newElement);
                    }
                    break;
                case "Renew":
                    break;
            }


            input = scanner.nextLine();
        }

    }
}
