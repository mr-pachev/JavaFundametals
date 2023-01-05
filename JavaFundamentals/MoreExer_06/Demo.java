package MoreExer_06;

import java.util.*;
import java.util.stream.Collectors;

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

            if (!usersMap.containsKey(contest)) { //проверка дали курса не съществува
                User user = new User(name, points);
                userList = new ArrayList<>();
                userList.add(user);
                usersMap.put(contest, userList);
            } else {
                boolean isExistUser = false;

                for (User user : usersMap.get(contest)) {
                    if (user.getUser().equals(name)) { //проверка дали участника съществува
                        isExistUser = true;
                    }
                }
                if (!isExistUser) {
                    User user = new User(name, points);
                    userList.add(user);
                    usersMap.put(contest, userList);
                } else {
                    for (User user : usersMap.get(contest)) {
                        if (user.getPoints() <= (points) && user.getUser().equals(name)) { //проверка дали дадените точки са повече от записаните вече
                            user.setPoints(points);
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<User>> entry : usersMap.entrySet()) {
            int counter = 1;
            System.out.printf("%s: %d participants%n", entry.getKey(), entry.getValue().size());
            List<User> collect = entry.getValue().stream()
                    .sorted((a, b) -> b.getPoints() - a.getPoints()).toList();

            for (User user : collect) {
                System.out.printf("%d. %s <::> %d%n", counter++, user.getUser(), user.getPoints());
            }
        }

        System.out.println("Individual standings:");
        Map<String, Integer> usersAllPointsMap = new LinkedHashMap<>();

        for (Map.Entry<String, List<User>> entry : usersMap.entrySet()) {

            entry.getValue().forEach(entry1 -> { //обхождаме само value-то на дневника във вид на листо от обекти
                if (!usersAllPointsMap.containsKey(entry1.getUser())) {
                    usersAllPointsMap.put(entry1.getUser(), entry1.getPoints());
                } else {
                    usersAllPointsMap.put(entry1.getUser(), usersAllPointsMap.get(entry1.getUser()) + entry1.getPoints());
                }
            });
        }

        List<Map.Entry<String, Integer>> collectUsersPointsList = usersAllPointsMap.entrySet().stream()
                .sorted((s1, s2) -> s2.getValue() - s1.getValue())
                .collect(Collectors.toList());

        int counter = 1;
        for (Map.Entry<String, Integer> entry : collectUsersPointsList){
            System.out.printf("%d. %s -> %d%n", counter++, entry.getKey(), entry.getValue());
        }
    }

    static class User {
        private String user;
        private int points;

        public User(String user, int points) {
            this.user = user;
            this.points = points;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public String getUser() {
            return this.user;
        }

        public int getPoints() {
            return this.points;
        }
    }
}
