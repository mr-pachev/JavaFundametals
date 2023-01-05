package MoreExer_06;

import java.util.*;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<User> userList = new ArrayList<>();
        Map<String, List<User>> usersMap = new LinkedHashMap<>();


        while (!input.equals("no more time")) {
            String[] inputData = input.split("\\s+->\\s+");

            String name = inputData[0];
            String contest = inputData[1];
            int points = Integer.parseInt(inputData[2]);

            if (!usersMap.containsKey(name)) { //проверка дали участника не съществува
                User user = new User(contest, points);
                userList = new ArrayList<>();
                userList.add(user);
                usersMap.put(name, userList);
            } else {
                boolean equalsContest = false;
                for (User user : userList){
                    equalsContest = user.getConstestName().equals(contest);
                }

                if (!equalsContest){
                    User user = new User(contest, points);
                    userList.add(user);
                    usersMap.put(name, userList);
                }else {
                    boolean isBigger = false;
                    for (User user : userList){
                       isBigger = user.getPoints() <= points;
                       }
                    if (isBigger){
                        usersMap.get(name).forEach(entry -> entry.setPoints(points));
                    }
                }
            }

            input = scanner.nextLine();
        }
        Map.Entry<K, V>
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
