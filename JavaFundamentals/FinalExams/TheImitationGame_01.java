package FinalExams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static MoreExerCompanyRoster_01.Main.isNumeric;

public class TheImitationGame_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> codedMessageList = new ArrayList<>(List.of(scanner.nextLine().split(""))); //списък от кодираната дума

        String input = scanner.nextLine();

        while(!input.equals("Decode")){

            String[] commands = input.split("\\|"); //масив с командите

            if (commands.length == 2){                              //преместване на елементи от началото вкрая
                int num = Integer.parseInt(commands[1]);
                for (int i = 0; i < num; i++) {
                    String current = codedMessageList.get(0);
                    codedMessageList.remove(codedMessageList.get(0));
                    codedMessageList.add(current);
                }

            }else if (commands.length == 3) {

                if (isNumeric(commands[1])) {                           //вмъкване на елемент
                    int index = Integer.parseInt(commands[1]);
                    String current = commands[2];

                    for (int i = 0; i < current.length() ; i++) {
                        String symbol = current.split("")[i];
                        codedMessageList.add(index, symbol);
                        index++;
                    }

                }else {                                                 //заместване на символ
                    String oldLetter = commands[1];
                    String newLetter = commands[2];

                    for(int i = 0; i < codedMessageList.size(); i++){
                        if (oldLetter.equals(codedMessageList.get(i))){
                            codedMessageList.set(i, newLetter);
                        }
                    }
                }

            }

            input = scanner.next();
        }

        System.out.print("The decrypted message is: ");
        for (String s : codedMessageList){
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
