package MidExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class TreasureHunt_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> tresureList = Arrays.stream(scanner.nextLine()
                .split("\\|")).collect(Collectors.toList()); //списък със съкровището

        String input = scanner.nextLine(); //вход от конзолата

        while (!input.equals("Yohoho!")) {
            String[] inputArr = input.split(" "); //масив съдържащ входните данни
            String command = inputArr[0]; //команда

            if (command.equals("Loot")) { //добавяне на съкровище

                for (int index = 1; index <= inputArr.length - 1; index++) { //обхождане на масива със съкровищата за добавяне
                    String currentElement = inputArr[index]; //текущ елемент

                    if (!tresureList.contains(currentElement)) { //проверка дали даденото съкровище е в списъка със съкровища
                        tresureList.add(0, currentElement); //добавяне на съкровището в началото на списъка
                    }
                }

            } else if (command.equals("Drop")) { //преместване
                int indexForDrop = Integer.parseInt(inputArr[1]); //индекс за преместване

                if (indexForDrop >= 0 && indexForDrop <= tresureList.size() - 1) { //проверка дали индекса е валиден
                    String elementForDrop = tresureList.get(indexForDrop); //елемент за преместване

                    tresureList.remove(indexForDrop); //премахваме индекса
                    tresureList.add(elementForDrop); //добавяме елемента в края на списъка
                }

            } else if (command.equals("Steal")) {
                int elementsForSteal = Integer.parseInt(inputArr[1]); //елементи за крадене от списъка със съкрове

                if (elementsForSteal > tresureList.size()) { //проверка дали има толкова елементи в списък
                    elementsForSteal = tresureList.size();
                }

                while (elementsForSteal > 1) {

                    System.out.printf("%s, ", tresureList.get(tresureList.size() - elementsForSteal));

                    tresureList.remove(tresureList.get(tresureList.size() - elementsForSteal)); //премахване на  съкровището от списъка
                    elementsForSteal--;
                }
                System.out.printf("%s%n", tresureList.get(tresureList.size() - elementsForSteal));
                elementsForSteal--;
                tresureList.remove(tresureList.get((tresureList.size() - 1) - elementsForSteal)); //премахване на  съкровището от списъка
            }

            input = scanner.nextLine();
        }

        if (tresureList.isEmpty()) { //проверка дали сандъка е празен
            System.out.println("Failed treasure hunt.");
        } else { //намиране на средната стойност на останалото съкровище
            int counterChar = 0;
            double avarage = 0;

            for (int index = 0; index <= tresureList.size() - 1; index++) {
                String element = tresureList.get(index);
                counterChar += element.length();
            }

            avarage = counterChar * 1.0 / tresureList.size();

            System.out.printf("Average treasure gain: %.2f pirate credits.", avarage);
        }
    }
}
