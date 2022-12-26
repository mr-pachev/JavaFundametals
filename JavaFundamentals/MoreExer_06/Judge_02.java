package MoreExer_06;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Judge_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputData = scanner.nextLine();
        Map<String, Integer> userPointsMap = new LinkedHashMap<>(); //дневник с потребителя и точките за конкретния курс
        Map<String, Map<String, Integer>> coursesMap = new LinkedHashMap<>(); //дневник с курсовете, потребителите в тях и точките им
        Map<String, Integer> pointsUsermap = new TreeMap<>();

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
                            userPointsMap = entry.getValue(); //конкретния дневник на дадения курс

                            if (entry1.getKey().equals(user)) { //проверка дали потребителя съществува за съответния курс
                                //взимане на най-голямата стойност на дадения потребител от входните данни спрямо дадения курс
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
                }
                //добавяне на нов потребител към съществуващия курс
                userPointsMap.put(user, maxPoints);
                coursesMap.put(course, userPointsMap);
            }
            inputData = scanner.nextLine();
        }

        int[] counter = new int[1]; //брояч от тип масив
        //първоначален печат
        coursesMap.forEach((key, value) -> {
            counter[0] = 0;
            System.out.printf("%s: %d participants%n", key, value.size());
            value.entrySet().stream().
                    sorted((f, s) -> s.getValue() - f.getValue()).
                    forEach(i -> System.out.printf("%d. %s <::> %d%n", ++counter[0], i.getKey(), i.getValue()));
        });

        //сборуване точките на всеки потребител и записванет им в дневника за потребители и точките им
        for (Map.Entry<String, Map<String, Integer>> entry : coursesMap.entrySet()) {
            for (Map.Entry<String,Integer> entry2:entry.getValue().entrySet()) {
                pointsUsermap.putIfAbsent(entry2.getKey(), 0);
                pointsUsermap.put(entry2.getKey(), pointsUsermap.get(entry2.getKey()) + entry2.getValue());
            }
        }

        //сортиране на дневника с потребителите и точките им в низходящ ред и принтирането им
        counter[0] = 0;
        System.out.println("Individual standings:");
        pointsUsermap.entrySet().stream().sorted((s1,s2)->
        {
            if(s2.getValue()>s1.getValue()) return 1;
            else if(s2.getValue()<s1.getValue()) return -1;
            else return s1.getKey().compareTo(s2.getKey());
        }).forEach(c-> {
            System.out.printf("%d. %s -> %d%n", ++counter[0], c.getKey(), c.getValue());
        });
    }
}
