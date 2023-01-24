package MoreExer_07;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] key = scanner.nextLine().split(" "); //вход ключ
        String input = scanner.nextLine();                 //текс за декриптиране
        String result = "";

        while (!input.equals("find")){

            result = "";
            char[] symbols = input.toCharArray();
            int count = 0;

            for (int i = 0; i < symbols.length; i++) {
                int symbolNum = (int) symbols[i];

                if(count < key.length) {
                    symbolNum -= Integer.parseInt(key[count]);
                }else {
                    count = 0;
                    symbolNum -= Integer.parseInt(key[count]);
                }
                count++;

                char currentSymbol = (char) symbolNum;
                result+=currentSymbol;
            }
            System.out.printf("Found %s at %s%n.", );
            input = scanner.nextLine();
        }


    }
}
