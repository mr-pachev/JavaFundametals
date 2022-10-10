package Exercises._07;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Integer> yieldMap = new LinkedHashMap<>();

        while (!command.equals("stop")) {
            String resource = command;
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!yieldMap.containsKey(command)) {
                yieldMap.put(resource, quantity);
            } else {
                int currentQuantity = yieldMap.get(resource);
                yieldMap.put(resource, currentQuantity + quantity);
            }

            command = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> item : yieldMap.entrySet()) {
            System.out.printf("%s -> %d%n", item.getKey(), item.getValue());
        }

    }
}
