package Lab._07;

import java.util.*;

public class OddOccurrences_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] incoming = scanner.nextLine().split(" "); // масив от стрингове с разделител " "

        Map<String, Integer> wordCounterMap = new LinkedHashMap<>(); // мап с подредба по начина на въвеждане

        for (int i = 0; i < incoming.length; i++) { // обхождаме масива
            String currentWord = incoming[i].toLowerCase(); // текущ елемент от масива плюс метода за превръщане в малки букви
            Integer value = wordCounterMap.get(currentWord); //локална променлива със стойност за ключа на мапа-текущияелемент на масива а за value-null

            if (!wordCounterMap.containsKey(currentWord)){ // проверка дали текущия елемент от масива се съдържа в мапа
                wordCounterMap.put(currentWord, 1); // добавяне на елемента в мапа със стойност за ключа на мапа-текущияелемент на масива а за value-1
            }else {
                wordCounterMap.put(currentWord, value + 1); // добавяне само на 1 към стойността на мапа
            }
        }
        List<String> oddWordsList = new ArrayList<>(); // създаваме списък, зада може при принтирането да използваме String.join
        for (Map.Entry<String, Integer> entry : wordCounterMap.entrySet()) {
            if (entry.getValue() % 2 != 0) { // проверка дали елемента е с нечетна стойнст
                oddWordsList.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", oddWordsList));
    }
}