package MidExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class TreasureHunt_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> tresureList = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        List<String> stealList = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("Yohoho!")) {
            String[] commandArr = input.split(" ");

            String command = commandArr[0]; //команда

            switch (command) {
                case "Loot": //прибавяне
                    for (int indexArr = 1; indexArr < commandArr.length; indexArr++) {
                        if (!(tresureList.contains(commandArr[indexArr]))) {
                            tresureList.add(0, commandArr[indexArr]);
                        }
                    }
                    break;
                case "Drop": //изпускане
                    int index = Integer.parseInt(commandArr[1]); //индекс на първия елемент
                    if (index >= 0 && index < tresureList.size()) { //проверка дали подадения индекса е валиден
                        String element = tresureList.get(index); //елемента отговарящ на подадения индекс
                        tresureList.remove(index); //премахване на индекса
                        tresureList.add(element); //добавяне на елемента на края на списъка със съкровища
                    }
                    break;
                case "Steal": //премахване на последните
                    int numElement = Integer.parseInt(commandArr[1]); //брой на елементите за премахване

                    if (numElement > tresureList.size()) { //проверка дали има достатъчно елементи за премахване в листа със съкровището
                        numElement = tresureList.size(); //елементите за премахване стават колкото е съкровището в листа
                    }

                    stealList = tresureList.subList(tresureList.size() - numElement, tresureList.size()); //пълни списъка с премахнатитет елементи

                    System.out.print(stealList.toString().replaceAll("[\\[\\],]", "")
                            .replaceAll(" ", ", "));

                    tresureList = tresureList.subList(0, tresureList.size() - numElement); //премахва последните съкровища от списъка

//                    for (int i = 1; i <= numElement; i++) { //цикъл според броя елементи за премахване
//                        stealList.add(tresureList.get(tresureList.size() - 1)); //добавя в листа на премахнатите елементи
//                        tresureList.remove(tresureList.size() - 1); //премахва от листа на съкровището
//                    }
//                    Collections.reverse(stealList);
//                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println();

        if (tresureList.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            int counterChar = 0;
            double avarage = 0;

            for (int index = 0; index < tresureList.size(); index++) {
                String element = tresureList.get(index);
                counterChar += element.length();
            }

            avarage = (counterChar * 1.0 / tresureList.size());

            System.out.printf("Average treasure gain: %.2f pirate credits.", avarage);
        }
    }
}
