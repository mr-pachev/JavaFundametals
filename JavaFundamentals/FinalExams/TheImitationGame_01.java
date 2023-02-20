package FinalExams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TheImitationGame_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String coded = scanner.nextLine();
        List<Character> codedMessageList = new ArrayList<>(); //масив от кодираната дума

        for (Character s : coded.toCharArray()){
            codedMessageList.add(s);
        }

        String input = scanner.nextLine();

        while(!input.equals("Decode")){

            String[] commands = input.split("\\|"); //масив с командите

            if (commands.length == 2){




            }else if (commands.length == 3){

            }

            input = scanner.next();
        }



    }
}
