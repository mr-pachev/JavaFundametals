package MoreExer_07;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] key = scanner.nextLine().split(" ");     //вход ключ
        String input = scanner.nextLine();                      //текс за декриптиране
        String result = "";                                     //ще пази откритите символи и интервали за печат

        while (!input.equals("find")){

            result = "";
            char[] symbols = input.toCharArray();               //входния низ се конвертира в масив от символи
            int count = 0;

            for (int i = 0; i < symbols.length; i++) {
                int symbolNum = (int) symbols[i];               //взимане на номера от ASCII таблицата на текущия символ от низа

                if(count < key.length) {                        //проверка осигуряваща превъртането на ключа по дължина на целия входящ низ
                    symbolNum -= Integer.parseInt(key[count]);  //изваждане стойността на ключа от номера в ASCII таблицата на текущия символ
                }else {
                    count = 0;
                    symbolNum -= Integer.parseInt(key[count]);
                }
                count++;

                char currentSymbol = (char) symbolNum;          //превръщане от int стойност в символ
                result+=currentSymbol;
            }
            String type = result.split("[\\&\\>]")[1];
            String point = result.split("[\\<\\>]")[1];
            System.out.printf("Found %s at %s%n", type, point);
            input = scanner.nextLine();
        }


    }
}
