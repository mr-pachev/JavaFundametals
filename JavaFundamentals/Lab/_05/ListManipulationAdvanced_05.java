package Lab._05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine(); // въвеждане на стринг от конзолата

        while (!input.equals("end")) {
            List<String> inputLine = Arrays.stream(input.split(" ")).collect(Collectors.toList()); // превръщане на стринга отконзолата в списък

            String comand = inputLine.get(0); // взимане на команда от стринга - винаги е на индекс 0

            int numb = 0;
            String oddOrEven = "";
            switch (comand) { // проверка на типа команда
                case "Contains":
                    numb = Integer.parseInt(inputLine.get(1));

                    if (numbersList.contains(numb)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;

                case "Print":
                    oddOrEven = inputLine.get(1);

                    if (oddOrEven.equals("even")) {
                        System.out.println(getEven(numbersList).toString().replaceAll("[\\[\\],]", ""));
                    } else if (oddOrEven.equals("odd")) {
                        System.out.println(getOdd(numbersList).toString().replaceAll("[\\[\\],]", ""));
                    }
                    break;

                case "Get":
                    int sum = 0;
                    for (int i = 0; i < numbersList.size(); i++) {
                        sum += numbersList.get(i);
                    }
                    System.out.println(sum);
                    break;

                case "Filter":
                    String symbol = inputLine.get(1);
                    int currentNumber = Integer.parseInt(inputLine.get(2));
                    System.out.println(getFilters(symbol, currentNumber, numbersList).toString().replaceAll("[\\[\\],]", ""));
                    break;
            }

            input = scanner.nextLine();
        }
    }
// метод за намиране на четните елементи от входящия списък и записването им в нов eventNumList
    public static List<Integer> getEven(List<Integer> inputList) {
        List<Integer> eventNumList = new ArrayList<>();

        for (int i = 0; i < inputList.size(); i++) {
            int current = inputList.get(i);
            if (current % 2 == 0) {
                eventNumList.add(current);
            }
        }
        return eventNumList;
    }

    // метод за намиране на нечетните елементи от входящия списък и записването им в нов oddtNumList
    public static List<Integer> getOdd(List<Integer> inputList) {
        List<Integer> oddNumList = new ArrayList<>();

        for (int i = 0; i < inputList.size(); i++) {
            int current = inputList.get(i);

            if (current % 2 != 0) {
                oddNumList.add(inputList.get(i));
            }

        }
        return oddNumList;
    }

// създаване на метод за проверка на типа знак от въведения стринг и съответното действие спрямо него с текущите елементи от numbersList
    public static List<Integer> getFilters(String symbol, int current, List<Integer> integerList) {
        List<Integer> filtersList = new ArrayList<>();
        String filter = symbol;
        int currentNum = current;
        int element = 0;

        if (symbol.equals("<")) {
            for (int i = 0; i < integerList.size(); i++) {
                element = integerList.get(i);

                if (element < currentNum) {
                    filtersList.add(element);
                }
            }
        } else if (symbol.equals(">")) {
            for (int i = 0; i < integerList.size(); i++) {
                element = integerList.get(i);

                if (element > currentNum) {
                    filtersList.add(element);
                }
            }
        } else if (symbol.equals(">=")) {
            for (int i = 0; i < integerList.size(); i++) {
                element = integerList.get(i);

                if (element >= currentNum) {
                    filtersList.add(element);
                }
            }
        } else if (symbol.equals("<=")) {
            for (int i = 0; i < integerList.size(); i++) {
                element = integerList.get(i);

                if (element <= currentNum) {
                    filtersList.add(element);
                }
            }
        }
        return filtersList;
    }
}
