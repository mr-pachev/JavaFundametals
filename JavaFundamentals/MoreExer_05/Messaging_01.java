package MoreExer_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<String> listResult = new ArrayList<>();
        String text = scanner.nextLine();
        List<String> textList = Arrays.stream(text.split("")).collect(Collectors.toList());


        for (int currentIndex = 0; currentIndex <= numbersList.size() - 1; currentIndex++) { //обхождаме листа
            String currentNum = numbersList.get(currentIndex).toString(); //поредния елемент от листа, като стринг
            int currentSumDigit = 0; //сумата от цифрите на дадения елемент

            if(isVald((sumDigit(currentNum)), textList)){
                currentSumDigit = sumDigit(currentNum); //сумата от цифрите на конкретното число
            }else{
                currentSumDigit = sumDigit(currentNum); //сумата от цифрите на конкретното число
                currentSumDigit = currentSumDigit - textList.size();
            }

            listResult.add(textList.get(currentSumDigit)); //добавяне на елемета от текста с отговарящ индекс на currentSumDigit
            textList.remove(currentSumDigit); //премахване на елемента с дадения и декс от сумата на цифрите

        }
        for (String symbol: listResult){
            System.out.print(symbol);
        }

    }
    public static boolean isVald (int index, List<String> textList){ //метод за проверка текущия индекс на елемента дали не е по-голям от дължината на стринга
        if (index > textList.size()){
            return false;
        }else {
            return true;
        }
    }

    public static Integer sumDigit (String num){ //сумира цифрите на дадено число
        int result = 0;
        for (int i = 0; i <= num.length() - 1; i++) {
            result +=Integer.parseInt(num.split("")[i]);
        }
        return result;
    }
}
