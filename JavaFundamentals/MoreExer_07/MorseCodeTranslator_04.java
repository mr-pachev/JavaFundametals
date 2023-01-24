package MoreExer_07;

import java.util.*;

public class MorseCodeTranslator_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> mourseMap = new LinkedHashMap<>();
        mourseMap.put(".-", "A");
        mourseMap.put("-...", "B");
        mourseMap.put("-.-.", "C");
        mourseMap.put("-..", "D");
        mourseMap.put(".", "E");
        mourseMap.put("..-.", "F");
        mourseMap.put("--.", "G");
        mourseMap.put("....", "H");
        mourseMap.put("..", "I");
        mourseMap.put(".---", "J");
        mourseMap.put("-.-", "K");
        mourseMap.put(".-..", "L");
        mourseMap.put("--", "M");
        mourseMap.put("-.", "N");
        mourseMap.put("---", "O");
        mourseMap.put(".--.", "P");
        mourseMap.put("--.-", "Q");
        mourseMap.put(".-.", "R");
        mourseMap.put("...", "S");
        mourseMap.put("-", "T");
        mourseMap.put("..-", "U");
        mourseMap.put("...-", "V");
        mourseMap.put(".--", "W");
        mourseMap.put("-..-", "X");
        mourseMap.put("-.--", "Y");
        mourseMap.put("--..", "Z");

       List<String> mourseCode = Arrays.stream(input.split("\\|")).toList();


        String result = "";
        for (String symbol : mourseCode){
            result += mourseMap.get(symbol);
        }
        System.out.println();

    }
}
