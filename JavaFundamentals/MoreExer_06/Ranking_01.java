package MoreExer_06;

import java.util.*;
import java.util.stream.Collectors;

public class Ranking_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputData = scanner.nextLine();
        Map<String, String> coursePassMap = new LinkedHashMap<>(); //дневник с курса и неговата парола
        Map<String, List<User>> usersCoursesMap = new TreeMap<>(); //дневник съдържащ потребителите и курсовете, в които участват
        List<User> userCursesList = new ArrayList<>();

        while (!inputData.equals("end of contests")) {
            String course = inputData.split(":")[0]; //името на курса
            String coursePassword = inputData.split(":")[1]; //паролата на курса
            coursePassMap.put(course, coursePassword); //пълнена на дневника
            inputData = scanner.nextLine();
        }

        inputData = scanner.nextLine();

        while (!inputData.equals("end of submissions")) {
            String currentCourse = inputData.split("=>")[0]; //текущ курс за обработка
            String currentCoursePass = inputData.split("=>")[1]; //текуща парола
            String currentUser = inputData.split("=>")[2]; //текущ потребител за обработка
            int currentUserPoints = Integer.parseInt(inputData.split("=>")[3]); //точки на текущия потребител

            User user = new User(currentCourse, currentUserPoints); //създаване на обект с новите данни
            boolean isExistUser = false;
            boolean isExistCourse = false;

            if (coursePassMap.containsKey(currentCourse)
                    && (coursePassMap.containsValue(currentCoursePass))) { //проверка дали текущия курс съществува в дневника на съществуващите курсове
                //и паролата към него е коректна
                if (usersCoursesMap.isEmpty()) {
                    userCursesList.add(user);
                    usersCoursesMap.put(currentUser, userCursesList);
                    inputData = scanner.nextLine();
                    continue;
                }

                for (Map.Entry<String, List<User>> entry : usersCoursesMap.entrySet()) { //обхождане на дневника
                    userCursesList = usersCoursesMap.get(currentUser);
                    if (entry.getKey().equals(currentUser)) { //проверка дали конкретния потребител съществува в дневника

                        for (User user1 : usersCoursesMap.get(currentUser)) { //обхождаме листа с обектите
                            if (user1.getCourses().equals(currentCourse)) { //проверяваме конкретния курс дали съществува в обекта
                                isExistCourse = true;
                                if (user1.getPoints() <= currentUserPoints) { //проверяваме дали точките от конкретния обект са по-малко от текущите точки
                                    user1.setPoints(currentUserPoints); //добавяне на текущите точки към обекта
                                    break;
                                }
                            }
                        }
                        if (!isExistCourse) {
                            userCursesList.add(user);
                            usersCoursesMap.put(currentUser, userCursesList); //добавяне новия курс към потребителя
                        }
                        isExistUser = true;
                    }
                }

                if (!isExistUser) { //добавяне на новия потребител с курса и точките
                    userCursesList = new ArrayList<>();
                    userCursesList.add(user);
                    usersCoursesMap.put(currentUser, userCursesList);
                    inputData = scanner.nextLine();
                    continue;
                }
            }
            inputData = scanner.nextLine();
        }

        int allUserPoints = 0;
        Map<String, Integer> userPointsMap = new LinkedHashMap<>(); //дневник съдържащ потребителите и общият им брой точки

        //обхождане на дневника за сброруване на точките на всеки потребител
        for (Map.Entry<String, List<User>> entry : usersCoursesMap.entrySet()) {
            allUserPoints = 0;
            for (User user1 : entry.getValue()) { //обхождаме листа с обектите
                allUserPoints += user1.getPoints();
            }
            userPointsMap.put(entry.getKey(), allUserPoints);
        }

        //намиране на потребителя с най-много точки
        String userMaxPoin = "";
        int maxPoints = 0;
        for (Map.Entry<String, Integer> entry : userPointsMap.entrySet()) {
            if (entry.getValue() >= maxPoints) {
                maxPoints = entry.getValue();
                userMaxPoin = entry.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n", userMaxPoin, maxPoints);
        System.out.println("Ranking: ");

        Map<String, List<User>> temporaryMap = new LinkedHashMap<>();

        //намиране на курса с най-малко точки на съответния потребител
        Map<String, List<Integer>> coursesCurrentPoints = new LinkedHashMap<>();
        for (Map.Entry<String, List<User>> entry : usersCoursesMap.entrySet()) {
            List<Integer> pointsList = new ArrayList<>();
            for (User user : entry.getValue()) {
                pointsList.add(user.points);
            }
            coursesCurrentPoints.put(entry.getKey(), pointsList);
        }





        for (Map.Entry<String, List<User>> entry : usersCoursesMap.entrySet()) {
            System.out.println(entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("# " + user.getCourses() + " -> " + user.getPoints());
            }
        }
        System.out.println();
    }

    public static class User {
        String course;
        int points;

        private User(String course, int points) {
            this.course = course;
            this.points = points;
        }

        public String getCourses() {
            return this.course;
        }

        public int getPoints() {
            return this.points;
        }

        public void setPoints(int points) {
            this.points = points;
        }
    }
}


