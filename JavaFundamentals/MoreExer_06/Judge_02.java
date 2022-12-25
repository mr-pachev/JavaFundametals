package MoreExer_06;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Judge_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputData = scanner.nextLine();
        Map<String, Integer> userPointsMap = new LinkedHashMap<>(); //дневник с потребителя и точките за конкретния курс
        Map<String, Map<String, Integer>> coursesMap = new LinkedHashMap<>(); //дневник с курсовете, потребителите в тях и точките им
        
        while (!inputData.equals("no more time")){
            String user = inputData.split(" -> ")[0]; //участник
            String course = inputData.split(" -> ")[1]; //конкуркс
            int points = Integer.parseInt(inputData.split(" -> ")[2]); //точки

            if (!coursesMap.containsKey(course)) { //проверка дали курса не съществува
                userPointsMap = new LinkedHashMap<>();
                userPointsMap.put(user, points);
                coursesMap.put(course, userPointsMap);
            }else {
                //обхождане на целиs дневник
               for(Map.Entry<String, Map<String, Integer>> entry : coursesMap.entrySet()){
                   int maxPoints = 0;
                   for (Map.Entry<String, Integer> entry1 : userPointsMap.entrySet()){
                       if (!entry1.getKey().equals(user)){ //проверка дали потребителя не съществува за съответния курс
                           //добавяне на нов потребител към съществуващия курс
                           userPointsMap.put(user, points);
                           coursesMap.put(course, userPointsMap);
                       }else {

                       }
                   }
               }

            }

            inputData = scanner.nextLine();
        }
    }
}
