package MoreExer_06;

import java.util.*;

public class Ranking_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputData = scanner.nextLine();
        Map<String, String> coursePassMap = new LinkedHashMap<>(); //дневник с курса и неговата парола

        while (!inputData.equals("end of contests")) {
            String course = inputData.split(":")[0]; //името на курса
            String coursePassword = inputData.split(":")[1]; //паролата на курса
            coursePassMap.put(course, coursePassword); //пълнена на дневника
            inputData = scanner.nextLine();
        }

        inputData = scanner.nextLine();

        Map<String, List<User>> usersCoursesMap = new TreeMap<>(); //дневник съдържащ потребителите и курсовете, в които участват
        List<User> userCurrentList = new ArrayList<>();

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

                if (usersCoursesMap.isEmpty()) {
                    userCurrentList.add(user);
                    usersCoursesMap.put(currentUser, userCurrentList);
                    inputData = scanner.nextLine();
                    continue;
                }

                for (Map.Entry<String, List<User>> entry : usersCoursesMap.entrySet()) {
                    if (entry.getKey().equals(currentUser)) { //проверка дали конкретния потребител съществува в дневника

                        for (User user1 : usersCoursesMap.get(currentUser)) { //обхождаме листа с обектите
                            if (entry.getKey().equals(currentUser) && user1.getCourses().equals(currentCourse)) { //проверяваме конкретния курс дали съществува в обекта
                                if (user1.getPoints() <= currentUserPoints) { //проверяваме дали точките от конкретния обект са по-малко от текущите точки
                                    user1.setPoints(currentUserPoints); //добавяне на текущите точки към обекта
                                    isExistCourse = true;
                                    break;
                                }
                            }
                        }
                        isExistUser = true;
                    }
                }
                if (!isExistUser) { //добавяну на новия потребител с курса и точките
                    userCurrentList = new ArrayList<>();
                    userCurrentList.add(user);
                    usersCoursesMap.put(currentUser, userCurrentList);
                    inputData = scanner.nextLine();
                    continue;
                }

                if(!isExistCourse){
                    userCurrentList.add(user);
                    usersCoursesMap.put(currentUser, userCurrentList); //добавяне новия курс към потребителя
                }
            }


            inputData = scanner.nextLine();
        }

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


