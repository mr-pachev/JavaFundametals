package MoreExer_06;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, User> usersMap = new LinkedHashMap<>();


        while (!input.equals("no more time")) {
            String[] inputData = input.split("\\s+->\\s+");

            String name = inputData[0];
            String contest = inputData[1];
            int points = Integer.parseInt(inputData[2]);

            if (!usersMap.containsKey(name)) { //проверка дали участника не съществува
                usersMap.put(name, new User(contest, points));
            } else {
                if (!usersMap.get(name).getConstestName().equals(contest)) { //проверка дали курса на чустаника не съществува
                   
                }else {
                    int points1 = usersMap.get(name).getPoints();

                    System.out.println();
                }
            }

            input = scanner.nextLine();
        }
        System.out.println();
    }

    static class User {
        private String constestName;
        private int points;

        public User(String constestName, int points) {
            this.constestName = constestName;
            this.points = points;
        }

        public void setConstestName(String constestName) {
            this.constestName = constestName;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public String getConstestName() {
            return this.constestName;
        }

        public int getPoints() {
            return this.points;
        }
    }
}
