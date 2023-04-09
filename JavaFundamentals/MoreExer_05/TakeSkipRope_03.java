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

        List<Integer> numberList = makeNumList(textSymbolList); //списък с цифри
        List<String> textList = makeSymbolList(textSymbolList); //списък само с букви
        List<Integer> takeList = evenList(numberList); //Take list
        List<Integer> skipList = oddList(numberList); //Skip list
        List<String> resultList = new ArrayList<>(); //декриптираният текст


        for (int currentIndex = 0; currentIndex < numberList.size() / 2; currentIndex++) { //обхожда двата списъка takeList и skipeList

           if (takeList.get(0) != 0) {
               for (int indexTake = 0; indexTake < takeList.get(0); indexTake++) { //взима елементите до currentElementTakeList
                  if (!textList.isEmpty()) { //проверка дали има останали елементи от textList
                      String currenSymbol = textList.get(0);
                      resultList.add(currenSymbol); //пълнене на списъка с декриптирания текст
                      textList.remove(0);
                  }else {
                      break;
                  }
               }
               takeList.remove(0);

           } else{
               takeList.remove(0);
           }

            if (skipList.get(0) != 0) {
                for (int indexSkip = 0; indexSkip < skipList.get(0); indexSkip++) {
                    if (!textList.isEmpty()) { //проверка дали има елементи за премахване
                        textList.remove(0);
                    }else {
                        break;
                    }
                }
                skipList.remove(0);

            }else {
                skipList.remove(0);
            }


        }
        for (String elemnt: resultList) {
            System.out.print(elemnt);
        }
    }

    //създава списък само с цифри
    public static List<Integer> makeNumList(List<String> inputList) {
        List<Integer> digitList = new ArrayList<>(); //списък за цифрите
        for (int currentIndex = 0; currentIndex <= inputList.size() - 1; currentIndex++) { //обхождаме входящия списък
            char currentChar = (inputList.get(currentIndex)).charAt(0); //превръщаме текущия елемент в символ
            if (currentChar >= 48 && currentChar <= 57) { //проверка дали символа е цифра
                int element = Integer.parseInt(inputList.get(currentIndex)); //превръщане на елемента в число
                digitList.add(element); //добавяне на цифрата в списъка
            }
        }
        return digitList;
    }

    //създава списък само с букви
    public static List<String> makeSymbolList(List<String> inputList) { //премахва цифрите и оставя само буквите
        for (int currentIndex = 0; currentIndex <= inputList.size() - 1; currentIndex++) { //обхождаме входящия списък
            char currentChar = (inputList.get(currentIndex)).charAt(0); //превръщаме текущия елемент в символ
            if (currentChar >= 48 && currentChar <= 57) { //проверка дали символа е цифра
                inputList.remove(currentIndex); //премахване на цифрата от списъка
                currentIndex--;
            }
        }
        return inputList;
    }

    //създаване на TakeList
    public static List<Integer> evenList(List<Integer> evenTakeList) {
        List<Integer> takeList = new ArrayList<>();
        for (int currentIndex = 0; currentIndex <= evenTakeList.size() - 1; currentIndex++) { //обхождаме списъка с цифри, зада запълним takeList и skipList
            int currentElements = evenTakeList.get(currentIndex);

            if (currentIndex % 2 == 0) { //запълване на takeList
                takeList.add(currentElements);
            }
        }
        return takeList;
    }

    //създаване на skipList
    public static List<Integer> oddList(List<Integer> oddSkipList) {
        List<Integer> skipList = new ArrayList<>();
        for (int currentIndex = 0; currentIndex <= oddSkipList.size() - 1; currentIndex++) { //обхождаме списъка с цифри, зада запълним takeList и skipList
            int currentElements = oddSkipList.get(currentIndex);

            if (currentIndex % 2 != 0) { //запълване на takeList
                skipList.add(currentElements);
            }
        }
        return skipList;
    }

}