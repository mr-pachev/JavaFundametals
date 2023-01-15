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

                    if (!playersDataMap.get(player).containsKey(position)) {            //проверка дали конкретната позиция НЕ съществува
                        playersDataMap.get(player).put(position, skill);                //взимане на конкретния играч и добавяне на новата позиция и умение
                    } else {
                        if (playersDataMap.get(player).get(position) < skill) {         //достигане стойността на и на двата речника
                            playersDataMap.get(player).put(position, skill);            //достигане стойността на основния речник и промяната й
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
                            if (s.equals(s1)) {                                         //проверка дали има обща стойност от тип String спрямо двата ключа
                                isExist = true;
                                break;
                            }
                        }
                    }
                    if (isExist) {

                        if (playersDataMap.get(firtsPlayer).values().stream()       //взимане сумата но стойностите тип Integer на основния речник спрямо ключ firstPlayer
                                .mapToInt(i -> i)
                                .sum()
                                >
                                playersDataMap.get(secondPlayer).values().stream()  //взимане сумата но стойностите тип Integer на основния речник спрямо ключ secondPlayer
                                        .mapToInt(i -> i)
                                        .sum()
                        ) {
                            playersDataMap.remove(secondPlayer);                    //премахване на ключа на основния речник с по-малко общи точки от стойността
                        } else if (playersDataMap.get(firtsPlayer).values().stream()
                                .mapToInt(i -> i)
                                .sum()
                                <
                                playersDataMap.get(secondPlayer).values().stream()
                                        .mapToInt(i -> i).sum()) {
                            playersDataMap.remove(firtsPlayer);                      //премахване на ключа на основния речник с по-малко общи точки от стойността
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }

        playersDataMap.entrySet()
                .stream()
                .sorted((p1, p2) -> { //сортировка в низходящ ред на основния речник по стойност -> сумата от стойностите на речника-стойност
                    int result = Integer.compare(p2.getValue().values().stream()
                                    .mapToInt(i -> i)
                                    .sum(),
                            p1.getValue().values().stream()
                                    .mapToInt(i -> i)
                                    .sum());
                    if (result == 0) { //при равенство на сортировка в низходящ ред на основния речник по стойност -> сумата от стойностите на речника-стойност
                        result = p1.getKey().compareTo(p2.getKey());   //сортира основния речник по ключ във възходящ ред
                    }
                    return result;
                })
                .forEach(entry -> {
                    System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue().values().stream()
                                                                                                .mapToInt(i -> i)
                                                                                                .sum());
                    entry.getValue()                                    //обхождане на втория ребник
                            .entrySet()
                            .stream()
                            .sorted((e1, e2) -> {
                                int res = Integer.compare(e2.getValue(), e1.getValue());    //сортиране по низходящ ред на стойностите от тип Integer от втория речник
                                if (res == 0) {                                             //при равенство от сортирането по низходящ ред на стойностите от тип Integer от втория речник
                                    res = e1.getKey().compareTo(e2.getKey());               //сортиране във възходящ ред на ключа от втория речник-позицията
                                }
                                return res;
                            }).forEach(e -> {
                                System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue());
                            });
                });

    }
}
