import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sumStudents = Integer.parseInt(scanner.nextLine());
        int sumCourses = Integer.parseInt(scanner.nextLine());
        int coursesBonus = Integer.parseInt(scanner.nextLine());

        int[] currentStudentArr = new int[sumStudents];

        for (int currentStudent = 0; currentStudent < sumStudents; currentStudent++) {
            int sumVisitsStudent = Integer.parseInt(scanner.nextLine());

            currentStudentArr[currentStudent] = sumVisitsStudent;
        }
        System.out.println();
    }
}
