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

        Map<String, Map<String, Integer>> playersDataMap = new HashMap<>();
        Map<String, Integer> currentMap = new LinkedHashMap<>();

        while (!input.equals("Season end")) {

            if (input.contains(" -> ")) {
                String player = input.split(" -> ")[0];
                String position = input.split(" -> ")[1];
                int skill = Integer.parseInt(input.split(" -> ")[2]);


                if (!playersDataMap.containsKey(player)) {                   //проверка дали играча съществува
                    currentMap.put(position, skill);
                    playersDataMap.put(player, currentMap);
                } else {
                    if(!playersDataMap.get(player).containsKey(position)){  //проверка дали конкретната позиция НЕ съществува
                        playersDataMap.get(player).put(position, skill);    //взимане на конкретния играч и добавяне на новата позиция и умение
                    }else {
                        
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
