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

        for (int currentIndex = 0; currentIndex <= textSymbolList.size() - 1; currentIndex++) { //обхождаме входящия списък
            char currentChar = (textSymbolList.get(currentIndex)).charAt(0); //превръщаме текущия елемент в символ
            if (currentChar >= 48 && currentChar <= 57){ //проверка дали символа е цифра
                int element = Integer.parseInt(textSymbolList.get(currentIndex)); //превръщане на елемента в число
                digitList.add(element); //добавяне на числото в списъка
            }
        }

    }
}
