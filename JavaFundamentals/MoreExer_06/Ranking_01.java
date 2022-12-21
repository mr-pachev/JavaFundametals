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

        Map<String, List<String>> coursesUsersMap = new LinkedHashMap<>(); //дневник съдържащ валидните курсове с потребителите записани в тях
        Map<String, Integer> usersPointsMap = new LinkedHashMap<>(); //дневник с потребители и техните точки


        while (!inputData.equals("end of submissions")) {

            String currentCourse = inputData.split("=>")[0]; //текущ курс за обработка
            String currentCoursePass = inputData.split("=>")[1]; //текущ курс за обработка
            String currentUser = inputData.split("=>")[2]; //текущ потребител за обработка
            int currentUserPoints = Integer.parseInt(inputData.split("=>")[3]); //точки на текущия потребител

            if (coursePassMap.containsKey(currentCourse) && (coursePassMap.containsValue(currentCoursePass))){ //проверка дали текущия курс съществува в дневника на съществуващите курсове
                List<String> usersInCourseList = coursesUsersMap.get(currentCourse);
                int userPoint = usersPointsMap.get(currentUser);

                if (usersInCourseList.contains(currentUser)){ //проверка дали дадения потребител вече не е записан в курса
                    usersPointsMap.put(currentUser, usersPointsMap.get(currentUser) + userPoint);

                }else {
                    coursesUsersMap.put(currentCourse, new ArrayList<>());
                    coursesUsersMap.get(currentCourse).add(currentUser);
                }
             
            }

            inputData = scanner.nextLine();
        }

    }
}
