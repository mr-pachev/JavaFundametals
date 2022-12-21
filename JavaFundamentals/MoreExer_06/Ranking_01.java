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

        Map<String, List<String>> usersCoursesMap = new LinkedHashMap<>(); //дневник съдържащ потребителите и курсовете, в които участват
        Map<String, Integer> usersPointsMap = new LinkedHashMap<>(); //дневник с потребители и техните точки


        while (!inputData.equals("end of submissions")) {

            String currentCourse = inputData.split("=>")[0]; //текущ курс за обработка
            String currentCoursePass = inputData.split("=>")[1]; //текущ курс за обработка
            String currentUser = inputData.split("=>")[2]; //текущ потребител за обработка
            int currentUserPoints = Integer.parseInt(inputData.split("=>")[3]); //точки на текущия потребител

            if (coursePassMap.containsKey(currentCourse) && (coursePassMap.containsValue(currentCoursePass))){ //проверка дали текущия курс съществува в дневника на съществуващите курсове
                List<String> usersInCoursesList = usersCoursesMap.get(currentUser);
//                int userPoint = usersPointsMap.get(currentUser);

                if (usersCoursesMap.containsKey(currentUser)){ //проверка дали дадения потребител вече не е записан в дневника с потребители и техните курсове
//                    usersPointsMap.put(currentUser, usersPointsMap.get(currentUser) + userPoint);

                }else {
                    usersCoursesMap.put(currentUser, new ArrayList<>());
                    usersCoursesMap.get(currentUser).add(currentCourse);
                }

            }

            inputData = scanner.nextLine();
        }

    }
}
