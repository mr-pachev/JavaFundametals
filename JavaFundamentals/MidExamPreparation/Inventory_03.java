package MidExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Inventory_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> itemsList = new java.util.ArrayList<>(Arrays.stream(scanner.nextLine().split(", "))
                .toList());

        String input = scanner.nextLine();

        while (!input.equals("Craft!")) {
            String[] inputArr = input.split(" - ");

            String command = inputArr[0]; //команда
            String item = inputArr[1]; //артикул

            if (command.equals("Collect")) { //добавяне
                if (!isExist(item, itemsList)) {
                    itemsList.add(item);
                }
            } else if (command.equals("Drop")) { //премахване
                if (isExist(item, itemsList)) {
                    itemsList.remove(item);
                }
            } else if (command.equals("Combine Items")) { //заместване
                String oldElement = item.split(":")[0];
                String newElement = item.split(":")[1];
                if (isExist(oldElement, itemsList)) {
                    int indexOldElemenf = itemsList.indexOf(oldElement);
                    itemsList.add(indexOldElemenf + 1, newElement);
                }

            } else if (command.equals("Renew")) { //промяна
                if (isExist(item, itemsList)) {
                    String buffer = item;
                    itemsList.remove(item);
                    itemsList.add(buffer);
                }
            }

            input = scanner.nextLine();
        }

       /* System.out.println(itemsList.toString().replaceAll("[\\[\\],]", "")
                .replaceAll(" ", ", "));
              
        */
        for (int i = 0; i <= itemsList.size() - 1; i++) {
            if (i == 0){
                System.out.printf("%s ", itemsList.get(i));
            }else {
                System.out.printf("%s, ", itemsList.get(i));
            }
        }
    }

    //проверка дали артикула съществува
    public static boolean isExist(String item, List<String> currentList) {

        return currentList.contains(item);
    }
}
