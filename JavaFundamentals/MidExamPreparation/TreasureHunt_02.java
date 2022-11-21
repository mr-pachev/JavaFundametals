package MidExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class TreasureHunt_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> tresureList = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        List<String> stilList = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("Yohoho!")) {
            String[] commandArr = input.split(" ");

            String command = commandArr[0]; //команда

            switch (command) {
                case "Loot": //прибавяне
                    for (int indexArr = 1; indexArr <= commandArr.length - 1; indexArr++) {
                        if (!isExist(commandArr[indexArr], tresureList)) {
                            tresureList.add(0, commandArr[indexArr]);
                        }
                    }
                    break;
                case "Drop": //изпускане
                    int index = Integer.parseInt(commandArr[1]); //индекс на първия елемент
                    if (isValid(index, tresureList)) {
                        String element = tresureList.get(index);
                        tresureList.remove(index);
                        tresureList.add(element);
                    }
                    break;
                case "Steal": //премахване на последните
                    int numElement = Integer.parseInt(commandArr[1]);
                    if (numElement >= tresureList.size()){
                        numElement = tresureList.size();
                    }
                    for (int i = 1; i <= numElement; i++) {
                        stilList.add(tresureList.get(tresureList.size() - 1));
                        tresureList.remove(tresureList.size() - 1);
                    }
                    Collections.reverse(stilList);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(stilList.toString().replaceAll("[\\[\\],]", "")
                                                        .replaceAll(" ", ", "));
        if(tresureList.isEmpty()){
            System.out.println("Failed treasure hunt.");
        }else {
            double avarage = avarageSum(tresureList);
            System.out.printf("Average treasure gain: %.2f pirate credits.", avarage);
        }
    }

    //проверка дали списъка съдържа елемента
    public static boolean isExist(String item, List<String> currentList) {
        boolean isExist = false;
        for (int i = 0; i <= currentList.size() - 1; i++) {
            if (item.equals(currentList.get(i))){
                isExist = true;
                break;
            }
        }
        return isExist;
        //return currentList.contains(item);
    }

    //проверка дали индекса е валиден
    public static boolean isValid(int index, List<String> currentList) {
        return (index >= 0 && index <= currentList.size() - 1);
    }

    //намиране средна стойност на съкровището
    public static Double avarageSum (List<String> currentList){
        int counterChar = 0;

        for (int index = 0; index <= currentList.size() - 1; index++) {
            counterChar += currentList.get(index).length();
        }
        return (counterChar * 1.0 / currentList.size());
    }
}
