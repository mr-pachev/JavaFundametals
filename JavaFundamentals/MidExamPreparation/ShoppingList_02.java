package MidExamPreparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> productsList = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")){
            String[] inputArr = input.split(" ");

            String command = inputArr[0]; //име на командата
            String element = inputArr[1]; //елемент

            switch (command){
                case "Urgent": //добавяне в началото на списъка
                    if (!isExist(element, productsList)){
                        productsList.add(0, element);
                    }
                    break;
                case "Unnecessary": //премахване на елемента
                    if (isExist(element, productsList)){
                        productsList.remove(element);
                    }
                    break;
                case "Correct": //смяна на продукт
                    String newElement = inputArr[2];
                    if (isExist(element, productsList)){
                        Collections.replaceAll(productsList, element, newElement);
                    }
                    break;
                case "Rearrange": //пренареждане
                    if (isExist(element, productsList)){
                        productsList.remove(element);
                        productsList.add(element);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        for (int i = 0; i <= productsList.size() - 1; i++) {
            if (i != productsList.size() - 1){
                System.out.printf("%s, ", productsList.get(i));
            }else {
                System.out.printf("%s", productsList.get(i));
            }
        }
    }

    //проверка дали елемента се съдържа в списъка
    public static boolean isExist (String element, List<String> currentList){
         return currentList.contains(element);
    }
}
