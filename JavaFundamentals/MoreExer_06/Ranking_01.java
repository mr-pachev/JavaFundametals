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

        Map<String, List<User>> usersCoursesMap = new LinkedHashMap<>(); //дневник съдържащ потребителите и курсовете, в които участват

        while (!inputData.equals("end of submissions")) {

            String currentCourse = inputData.split("=>")[0]; //текущ курс за обработка
            String currentCoursePass = inputData.split("=>")[1]; //текущ курс за обработка
            String currentUser = inputData.split("=>")[2]; //текущ потребител за обработка
            int currentUserPoints = Integer.parseInt(inputData.split("=>")[3]); //точки на текущия потребител
            User user = new User(currentCourse, currentUserPoints);
            List<User> userCurrentList = new ArrayList<>();

            if (coursePassMap.containsKey(currentCourse) && (coursePassMap.containsValue(currentCoursePass))){ //проверка дали текущия курс съществува в дневника на съществуващите курсове

                if (!usersCoursesMap.containsKey(currentUser)){

                    userCurrentList.add(user);

                    usersCoursesMap.put(currentUser, userCurrentList);
                }else {
                   if (usersCoursesMap.containsValue(currentCourse)){
                       
                   }
                }
                System.out.println();


            }

            inputData = scanner.nextLine();
        }

    }
    public static class User {
        String course;
        int points;

        private User (String course, int points){
            this.course = course;
            this.points =points;
        }

        public String getCourses() {
            return this.course;
        }

        public int getPoints() {
            return this.points;
        }
    }
}


