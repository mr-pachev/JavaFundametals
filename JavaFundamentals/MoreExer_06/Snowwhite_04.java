package MoreExer_06;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Snowwhite_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> dwarfDataMap = new LinkedHashMap<>();   //речник съдържащ цвета на шаппката, речник с името и физиката на джуджето


        while (!input.equals("Season end")) {
            String dwarfName = input.split(" <:> ")[0];                     //име на джуджето
            String dwarfHatColor = input.split(" <:> ")[1];                 //цвят на шапката на джуджето
            int dwarfPhysics = Integer.parseInt(input.split(" <:> ")[2]);   // физика на джуджето

            Map<String, Integer> currentMap = new LinkedHashMap<>();              //речник съдържащ името и физиката на джуджето
            currentMap.put(dwarfName, dwarfPhysics);

                if(!dwarfDataMap.containsKey(dwarfHatColor)){                     //проверка дали НЯМА такъв цвят шапка
                    dwarfDataMap.put(dwarfHatColor, currentMap);
            }else {

            }

            input = scanner.nextLine();
        }
        System.out.println();

    }
}

