package Lab._07;

import java.util.*;

public class WordSynonyms_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> wordsMaps = new LinkedHashMap<>(); // мап с ключове тип стринг и стойност списък

        for (int i = 1; i <= n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (!wordsMaps.containsKey(word)) { // проверка дали въведената дума се съдържа в мапа
                wordsMaps.put(word, new ArrayList<>()); // с метода put добавяме нов ключ-стойността на word и създаваме локален списък
                wordsMaps.get(word).add(synonym); // добавяме стойност synonym на value-в случая локалния списък
            } else {
                wordsMaps.get(word).add(synonym); // добавяме стойност synonym на value-в случая локалния списък
            }
        }
        for (Map.Entry<String, List<String>> entry : wordsMaps.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue())); // принтираме стойностите със String.join и разделител ", "
        }

    }
}
