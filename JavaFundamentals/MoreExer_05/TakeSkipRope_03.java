package MoreExer_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TakeSkipRope_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> textSymbolList = Arrays.stream(input.split("")).collect(Collectors.toList());

        List<Integer> digitList = new ArrayList<>(); //списък за цифрите
        List<Integer> takeList = new ArrayList<>(); //Take list
        List<Integer> skipList = new ArrayList<>(); //Skip list
        List<String> resultList = new ArrayList<>(); //декриптираният текст

        for (int currentIndex = 0; currentIndex <= textSymbolList.size() - 1; currentIndex++) { //обхождаме входящия списък
            char currentChar = (textSymbolList.get(currentIndex)).charAt(0); //превръщаме текущия елемент в символ
            if (currentChar >= 48 && currentChar <= 57){ //проверка дали символа е цифра
                int element = Integer.parseInt(textSymbolList.get(currentIndex)); //превръщане на елемента в число
                digitList.add(element); //добавяне на цифрата в списъка
                textSymbolList.remove(currentIndex); //премахване на цифрата от списъка
                currentIndex--;
            }
        }
        for (int currentIndex = 0; currentIndex <= digitList.size() - 1; currentIndex++) { //обхождаме списъка с цифри, зада запълним takeList и skipList
            int currentElements = digitList.get(currentIndex);

            if (currentElements % 2 == 0){ //запълване на takeList
                takeList.add(currentIndex);
            }else {
                skipList.add(currentIndex); //запълване на skipList
            }
        }
        
        for (int currentIndex = 0; currentIndex <= digitList.size() - 1; currentIndex++) { //обхождане на двата takeList и skipList последователно
            int currentElementTakeList = takeList.get(currentIndex);

            for (int indexTake = 0; indexTake < currentElementTakeList; indexTake++) { //определя броя на елементите за взимане от textSymbolList
                String currenSymbol = textSymbolList.get(indexTake);
                resultList.add(currenSymbol); //пълнене на списъка с декриптирания текст
            }

            currentIndex += skipList.get(currentIndex); //изпълняваме условието по текущия елемент от skipList

        }


    }
}
