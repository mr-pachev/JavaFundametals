package MoreExer_06;

import java.util.*;

public class Demo {
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
        List<String> userCourserList = new ArrayList<>();
        Map<String, List<String>> userCoursesMap = new TreeMap<>(); //съдържа курсовете, вкоито потребителя участва
        Map<String, List<String>> courseWithUsersMap = new TreeMap<>();

        while (!inputData.equals("end of submissions")) {
            String currentCourse = inputData.split("=>")[0]; //текущ курс за обработка
            String currentCoursePass = inputData.split("=>")[1]; //текуща парола
            String currentUser = inputData.split("=>")[2]; //текущ потребител за обработка
            int currentUserPoints = Integer.parseInt(inputData.split("=>")[3]); //точки на текущия потребител

            boolean isExist = false;

            if (coursePassMap.containsKey(currentCourse)
                    && (coursePassMap.containsValue(currentCoursePass))) { //проверка дали курса и паролата към него са верни


                if (userCoursesMap.isEmpty()) {
                    userCourserList.add(currentCourse);
                    userCoursesMap.put(currentUser, userCourserList);

                    inputData = scanner.nextLine();
                    continue;
                }

                if (userCoursesMap.containsKey(currentUser)) { //проверка дали потребителя съществува в дневника
                    for (String course : userCoursesMap.get(currentUser)) {
                        if (course.equals(currentCourse)) { //проверка дали дадения курс съществува в курсовете на потребителя
                            isExist = true;
                        }
                    }
                    if (!isExist){
                        userCoursesMap.get(currentUser).add(currentCourse); //добавяне на курс към конкретния потребител
                    }
                } else { //добавяне на нов потребител
                    userCourserList = new ArrayList<>();
                    userCourserList.add(currentCourse);
                    userCoursesMap.put(currentUser, userCourserList);
                }

            }

            inputData = scanner.nextLine();
        }
        System.out.println();
    }
}
