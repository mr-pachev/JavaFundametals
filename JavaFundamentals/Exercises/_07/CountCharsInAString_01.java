package Exercises._07;

import java.util.*;

public class CountCharsInAString_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String textInput = scanner.nextLine();

        Map<Character, Integer> characterMap = new LinkedHashMap<>();

        for (char currentChar : textInput.toCharArray()) {
            if (currentChar == ' ') {
                continue;
            }

            if (!characterMap.containsKey(currentChar)) {
                characterMap.put(currentChar, 1);
            } else {
                int symbol = characterMap.get(currentChar);
                characterMap.put((currentChar), symbol + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
