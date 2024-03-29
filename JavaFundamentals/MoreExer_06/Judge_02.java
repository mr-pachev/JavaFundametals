package MoreExer_06;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Judge_02 {
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

            if (!usersMap.containsKey(contest)) {   //проверка дали курса не съществува
                User user = new User(name, points);
                userList = new ArrayList<>();
                userList.add(user);
                usersMap.put(contest, userList);
                input = scanner.nextLine();
                continue;
            }

            boolean isExistUser = false;    //курса съществува

            for (Map.Entry<String, List<User>> item : usersMap.entrySet()) {
                for (User user : usersMap.get(contest)) {
                    if (user.getUserName().equals(name)) { //проверка дали участника съществува
                        isExistUser = true;
                        break;
                    }
                }
                if (!isExistUser) {
                    User user = new User(name, points);
                    userList = usersMap.get(contest);
                    userList.add(user);
                    usersMap.put(contest, userList);
                } else {
                    for (User user : usersMap.get(contest)) {
                        if (user.getPoints() <= (points) && user.getUserName().equals(name)) { //проверка дали дадените точки са повече от записаните вече
                            user.setPoints(points);
                        }
                    }
                }

            }

//                for (User user : usersMap.get(contest)) {
//                    if (user.getUserName().equals(name)) { //проверка дали участника съществува
//                        isExistUser = true;
//                        break;
//                    }
//                }
//                if (!isExistUser) {
//                    User user = new User(name, points);
//                    userList = usersMap.get(contest);
//                    userList.add(user);
//                    usersMap.put(contest, userList);
//                } else {
//                    for (User user : usersMap.get(contest)) {
//                        if (user.getPoints() <= (points) && user.getUserName().equals(name)) { //проверка дали дадените точки са повече от записаните вече
//                            user.setPoints(points);
//                        }
//                    }
//                }

            input = scanner.nextLine();
        }

        int[] counter = {1};
        for (Map.Entry<String, List<User>> entry : usersMap.entrySet()) {
            counter[0] = 1;
            System.out.printf("%s: %d participants%n", entry.getKey(), entry.getValue().size());
            entry.getValue().stream()
                    .sorted((s1, s2) -> {
                        if (s2.getPoints() == s1.getPoints()) {
                            return s1.getUserName().compareTo(s2.getUserName());
                        } else {
                            return s2.getPoints() - s1.getPoints();
                        }
                    })
                    .forEach(entry1 -> {
                        System.out.printf("%d. %s <::> %d%n", counter[0]++, entry1.getUserName(), entry1.getPoints());
                    });
        }

//        usersMap.forEach((k, v) -> {                                    //принтиране на основния дневник
//            int[] counter = {1};                                        //създваване на брояч вътре в ламбда израза
//            System.out.printf("%s: %d participants%n", k, v.size());    //принтиране на ключа и дължината на стойността
//            v.stream()                                                  //обхождане и сортиране на стойността, която е списък от обекти
//                    .sorted((s1, s2) ->(s2.getPoints() - s1.getPoints()))
//                    .forEach(i -> System.out.printf("%d. %s <::> %d%n", counter[0]++, i.getUserName(), i.getPoints()));
//        });

        System.out.println("Individual standings:");

        Map<String, Integer> usersAllPointsMap = new LinkedHashMap<>();

        for (Map.Entry<String, List<User>> entry : usersMap.entrySet()) {

            entry.getValue().forEach(entry1 -> {                    //обхождаме само value-то на дневника във вид на лист от обекти
                if (!usersAllPointsMap.containsKey(entry1.getUserName())) {
                    usersAllPointsMap.put(entry1.getUserName(), entry1.getPoints());
                } else {
                    usersAllPointsMap.put(entry1.getUserName(), usersAllPointsMap.get(entry1.getUserName()) + entry1.getPoints());
                }
            });
        }

        counter[0] = 1;
        usersAllPointsMap.entrySet().stream()
                .sorted((s1, s2) -> {
                    int sort = Integer.compare(s2.getValue(), s1.getValue());
                    if (sort == 0) {
                        sort = s1.getKey().compareTo(s2.getKey());
                    }
                    return sort;
                }).forEach((entry) -> {
                    System.out.printf("%d. %s -> %d%n", counter[0]++, entry.getKey(), entry.getValue());
                });

    }

    static class User {
        private final String userName;
        private int points;

        public User(String user, int points) {
            this.userName = user;
            this.points = points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public String getUserName() {
            return this.userName;
        }

        public int getPoints() {
            return this.points;
        }
    }
}
