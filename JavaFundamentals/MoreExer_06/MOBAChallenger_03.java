package MoreExer_06;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MOBAChallenger_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> playersDataMap = new LinkedHashMap<>();


        while (!input.equals("Season end")) {

            if (input.contains(" -> ")) {
                String player = input.split(" -> ")[0];
                String position = input.split(" -> ")[1];
                int skill = Integer.parseInt(input.split(" -> ")[2]);

                Map<String, Integer> currentMap = new LinkedHashMap<>();
                currentMap.put(position, skill);

                if (!playersDataMap.containsKey(player)) {                      //проверка дали играча съществува
                    playersDataMap.put(player, currentMap);
                } else {

                    if (!playersDataMap.get(player).containsKey(position)) {    //проверка дали конкретната позиция НЕ съществува
                        playersDataMap.get(player).put(position, skill);        //взимане на конкретния играч и добавяне на новата позиция и умение
                    } else {
                        if (playersDataMap.get(player).get(position) < skill) { //достигане стойността на и на двата речника
                            playersDataMap.get(player).put(position, skill);    //достигане стойността на основния речник и промяната й
                        }
                    }
                }
            } else if (input.contains(" vs ")) {
                String firtsPlayer = input.split(" ")[0];
                String secondPlayer = input.split(" ")[2];

                if (playersDataMap.containsKey(firtsPlayer) && playersDataMap.containsKey(secondPlayer)) { //проверка дали двамата играчи съществуват в речника

                    boolean isExist = false;
                    for (String s : playersDataMap.get(firtsPlayer).keySet()) {         //обхожда стойностите на основния речник спрямо ключа firstPlayer
                        for (String s1 : playersDataMap.get(secondPlayer).keySet()) {   //обхожда стойностите на основния речник спрямо ключа secondPlayer
                            if (s.equals(s1)) {         //проверка дали има обща стойност от тип String спрямо двата ключа
                                isExist = true;
                                break;
                            }
                        }
                    }
                    if(isExist){

                        if (playersDataMap.get(firtsPlayer).values().stream()
                                .mapToInt(i -> i)
                                .sum()
                                >
                                playersDataMap.get(secondPlayer).values().stream()
                                        .mapToInt(i -> i).sum()) {
                            playersDataMap.remove(secondPlayer);
                        } else if (playersDataMap.get(firtsPlayer).values().stream()
                                .mapToInt(i -> i).sum()
                                <
                                playersDataMap.get(secondPlayer).values().stream()
                                        .mapToInt(i -> i).sum()) {
                            playersDataMap.remove(firtsPlayer);
                        }
                    }

                }

            }
            input = scanner.nextLine();
        }
        System.out.println();
    }
}
