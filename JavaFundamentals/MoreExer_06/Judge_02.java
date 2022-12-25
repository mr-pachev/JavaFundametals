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

        while (!inputData.equals("no more time")) {
            String user = inputData.split(" -> ")[0]; //участник
            String course = inputData.split(" -> ")[1]; //конкуркс
            int points = Integer.parseInt(inputData.split(" -> ")[2]); //точки
            boolean isExistUser = false;

            if (!coursesMap.containsKey(course)) { //проверка дали курса не съществува
                userPointsMap = new LinkedHashMap<>();
                userPointsMap.put(user, points);
                coursesMap.put(course, userPointsMap);
            } else {
                //обхождане на целиs дневник
                int maxPoints = 0;
                for (Map.Entry<String, Map<String, Integer>> entry : coursesMap.entrySet()) {

                    if (entry.getKey().equals(course)) { //осигурява обхождане само на конкретния курс
                        for (Map.Entry<String, Integer> entry1 : entry.getValue().entrySet()) {
                            userPointsMap = entry.getValue();

                            if (entry1.getKey().equals(user)) { //проверка дали потребителя съществува за съответния курс

                                if (points >= maxPoints) {
                                    maxPoints = points;
                                } else {
                                    maxPoints = entry1.getValue();
                                }
                                isExistUser = true;
                                break;
                            }
                        }
                        if (!isExistUser) {
                            maxPoints = points;
                        }
                    }

//                    if (!isExistUser) {
//                        //добавяне на нов потребител към съществуващия курс
//                        userPointsMap.put(user, maxPoints);
//                        coursesMap.put(course, userPointsMap);
//                    }

                }
                //добавяне на нов потребител към съществуващия курс
                userPointsMap.put(user, maxPoints);
                coursesMap.put(course, userPointsMap);

            }

            inputData = scanner.nextLine();
        }
    }
}
