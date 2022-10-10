package Lab._07;

import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbersList = Arrays.stream(scanner.nextLine().split(" ")) // списък с входни данни от конзолата
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        Map<Double, Integer> counterNumMap = new TreeMap<>(); // мап с ключове дабъл и стойност интиджър

        for (double currentNum : numbersList) {

            if (counterNumMap.containsKey(currentNum)) { // проверка дали всеки пореден елемент от списъка се съдържа в мапа
                Integer currentValue = counterNumMap.get(currentNum);
                counterNumMap.put(currentNum, currentValue + 1); // добавяне на value - стойност
            } else {
                counterNumMap.put(currentNum, 1); // добавяне на нов елемент с ключ-currentNum и value(стойност)-1
            }
        }
        for (Map.Entry<Double, Integer> items : counterNumMap.entrySet()) {
            System.out.printf("%.0f -> %d%n", items.getKey(), items.getValue());
        }
    }
}
