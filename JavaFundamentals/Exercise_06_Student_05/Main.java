package Exercise_06_Student_05;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Student> studentList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {

            String incomming = scanner.nextLine();
            String firstName = incomming.split(" ")[0];
            String lastName = incomming.split(" ")[1];
            double grade = Double.parseDouble(incomming.split(" ")[2]);

            Student student = new Student(firstName, lastName, grade);
            studentList.add(student);
        }
        studentList.sort(Comparator.comparingDouble(Student::getGrade)
                .reversed());

        for (Student item : studentList){
            System.out.println(item.toString());
        }
    }
}
