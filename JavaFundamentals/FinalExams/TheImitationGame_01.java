package FinalExams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static MoreExerCompanyRoster_01.Main.isNumeric;

public class TheImitationGame_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String coded = scanner.nextLine();
        List<Character> codedMessageList = new ArrayList<>(); //списък от кодираната дума

        for (Character s : coded.toCharArray()){
            codedMessageList.add(s);
        }

        String input = scanner.nextLine();

        while(!input.equals("Decode")){

            String[] commands = input.split("\\|"); //масив с командите

            if (commands.length == 2){                              //преместване на елементи от началото вкрая
                int num = Integer.parseInt(commands[1]);
                for (int i = 0; i < num; i++) {
                    char current = codedMessageList.get(0);
                    codedMessageList.remove(0);
                    codedMessageList.add(current);
                }

            }else if (commands.length == 3) {

                if (isNumeric(commands[1])) {                           //вмъкване на елемент
                    int index = Integer.parseInt(commands[1]);
                    char current = commands[2].toCharArray()[0];
                    codedMessageList.add(index, current);
                }else {                                                 //заместване на символ
                    char oldLetter = commands[1].toCharArray()[0];
                    char newLetter = commands[2].toCharArray()[0];

                    for(int i = 0; i < codedMessageList.size(); i++){
                        if (oldLetter == codedMessageList.get(i)){
                            codedMessageList.set(i, newLetter);
                        }
                    }
                }

            }

            input = scanner.next();
        }

        for (Character s : codedMessageList){
            System.out.print(s);
        }

    }
    //метод за проверка дали String-a е число
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}
