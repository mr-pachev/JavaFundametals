package MoreExer_06;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MOBAChallenger_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<Player>> playersDataMap = new HashMap<>();

        while (!input.equals("Season end")) {

            if (input.contains(" -> ")) {
                String player = input.split(" -> ")[0];
                String position = input.split(" -> ")[1];
                int skill = Integer.parseInt(input.split(" -> ")[2]);

                Player player1 = new Player(position, skill);
                List<Player> playerDataList = new ArrayList<>();

                if (!playersDataMap.containsKey(player)) {                   //проверка дали играча съществува
                    playerDataList.add(player1);
                    playersDataMap.put(player, playerDataList);
                } else {

                    for (Player player2 : playersDataMap.get(player)) {
                        if (!player2.getPosition().equals(position)) {       //проверка дали коткретната позиция на дадения играч не съществува
                            player1 = new Player(position, skill);           //създаване на нов обект с новата позиция и умения
                            playerDataList = playersDataMap.get(player);     //взимане на текущата стойност-списък на речника
                            playerDataList.add(player1);                     //добавяне на новата позиция и умение към конкретния играч
                            playersDataMap.put(player, playerDataList);
                            break;
                        } else if (player2.getSkill() <= skill) {
                            player2.setSkill(skill);
                            break;
                        }
                    }
                }
            }else if (input.contains(" vs ")){
                String playerOne = input.split(" ")[0];
                String playerTwoo = input.split(" ")[2];

               if(!playersDataMap.containsKey(playerOne) && !playersDataMap.containsKey(playerTwoo)){ //проверка дали двамата играчи съществуват в речника
                   break;
               }else {


               }

            }
          input = scanner.nextLine();
        }
    }

    static class Player {
        private String position;
        private int skill;

        public Player(String position, int skill) {
            this.position = position;
            this.skill = skill;
        }

        public String getPosition() {
            return this.position;
        }

        public int getSkill() {
            return this.skill;
        }

        public void setSkill(int skill) {
            this.skill = skill;
        }
    }

}
