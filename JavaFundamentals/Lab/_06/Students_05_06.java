package Lab._06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students_05_06 {

    static class Student { // създаване на клас
        String firstName; // създаване на полета-параметри на класа
        String lastName;
        String age;
        String homeTown;

        public Student(String firstName, String lastName, String age, String homeTown) { // запълване на конструктура на класа Student-създаване на set-ери
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public String getFirstName() { // създаване на метод (get-ери) за достъп на полетата-параметрите на класа
            return this.firstName;
        }

        public void setFirstName(String firstName) { // създаване на метод (set-ери) за възможност за промяна на полетата-параметрите на класа
            this.firstName = firstName;
        }

        public String getLastName() { // създаване на метод (get-ери) за достъп на полетата-параметрите на класа
            return this.lastName;
        }

        public void setLastName(String lastName) { // създаване на метод (set-ери) за възможност за промяна на полетата-параметрите на класа
            this.lastName = lastName;
        }

        public String getAge() { // създаване на метод (get-ери) за достъп на полетата-параметрите на класа
            return this.age;
        }

        public void setAge(String age) { // създаване на метод (set-ери) за възможност за промяна на полетата-параметрите на класа
            this.age = age;
        }

        public String getHomeTown() { // създаване на метод (get-ери) за достъп на полетата-параметрите на класа
            return this.homeTown;
        }

        public void setHomeTown(String homeTown) { // създаване на метод (set-ери) за възможност за промяна на полетата-параметрите на класа
            this.homeTown = homeTown;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        List<Student> studentList = new ArrayList<>(); // списък за студентите

        while (!command.equals("end")) {
            String[] currentStudent = command.split(" "); // масив с разделител за входящите данни за студента
            String incomingFirstName = currentStudent[0];
            String incomingLastName = currentStudent[1];
            String incomingAge = currentStudent[2];
            String incomingHomeTown = currentStudent[3];

            if (isExist(studentList, incomingFirstName, incomingLastName)) { // проверка с метода дали съществува студента в списъка по име
                Student studentData = getStudent(studentList, incomingFirstName, incomingLastName); // презапис на firstName и lastName с помоща на метода за презапис
                studentData.setFirstName(incomingFirstName);
                studentData.setLastName(incomingLastName);
                studentData.setAge(incomingAge);
                studentData.setHomeTown(incomingHomeTown);

            } else {
                Student studentData = new Student(incomingFirstName, incomingLastName, incomingAge, incomingHomeTown); // обект от класа Student със запълнен параметри от масива
                studentList.add(studentData); // запълване на списъка от обекта studentData с запълнените вече параметри
            }
            command = scanner.nextLine();
        }
        String town = scanner.nextLine();

        for (Student items : studentList) {
            if (town.equals(items.getHomeTown())) { // проверка town отговаря ли на полето-параметър homeTown
                System.out.printf("%s %s is %s years old%n", items.getFirstName(), items.getLastName(), items.getAge());
            }
        }
    }

    private static boolean isExist(List<Student> students, String firstName, String lastName) { //  метод за проверка дали студента съществува в списъка

        for (Student item : students) {
            if (item.getFirstName().equals(firstName) && item.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    private static Student getStudent(List<Student> students, String firstName, String lastName) { // метод за презапис параметрите firstName и lastName на студента
        Student existingStudent = null;

        for (Student item : students) {
            if (item.getFirstName().equals(firstName) && item.getLastName().equals(lastName)) {
                existingStudent = item;
            }
        }
        return existingStudent;
    }
}
