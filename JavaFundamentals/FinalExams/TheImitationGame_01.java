package FinalExams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static MoreExerCompanyRoster_01.Main.isNumeric;

public class TheImitationGame_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String incoming = scanner.nextLine();
        List<String> codedMessageList = Arrays.stream(incoming.split("")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Decode")) {

            String[] commands = input.split("\\|"); //масив с командите

            if (commands.length == 2) {                              //преместване на елементи от началото вкрая
                int num = Integer.parseInt(commands[1]);
                edithList(num, codedMessageList);

            } else if (commands.length == 3) {

                if (isNumeric(commands[1])) {                           //вмъкване на елемент
                    int index = Integer.parseInt(commands[1]);
                    String current = commands[2];

                    insertIntoList(codedMessageList, index, current);

                } else {                                                 //заместване на символ
                    String oldLetter = commands[1];
                    String newLetter = commands[2];

                    codedMessageList.toString();
                    replaceElements(codedMessageList, oldLetter, newLetter);
                }
            }

            input = scanner.next();
        }

        System.out.print("The decrypted message is: ");
        for (String s : codedMessageList) {
            System.out.print(s);
        }
    }

    public static List<String> edithList(int num, List<String> currentList){
        for (int i = 0; i < num; i++) {
            String current = currentList.get(0);
            currentList.remove(currentList.get(0));
            currentList.add(current);
        }
        return currentList;
    }

    public static List<String> insertIntoList(List<String> list, int index, String symbol){
        for (int i = 0; i < symbol.length(); i++) {
            String letter = symbol.split("")[i];
            list.add(index, symbol);
            index++;
        }
        return list;
    }
    public  static List<String> replaceElements(List<String> list, String oldLetter, String newLetter){
        for (int i = 0; i < list.size(); i++) {
            if (oldLetter.equals(list.get(i))) {
                list.set(i, newLetter);
            }
        }
        return list;
    }
    //метод за проверка дали String-a е число
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }



}
