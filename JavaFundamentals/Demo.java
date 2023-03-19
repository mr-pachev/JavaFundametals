import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sumStudents = Integer.parseInt(scanner.nextLine());   //брой студенти
        int sumCourses = Integer.parseInt(scanner.nextLine());    //общ брой лекций
        int coursesBonus = Integer.parseInt(scanner.nextLine());  //допълнителен бонус

        double[] studentMaxBonus = new double[sumStudents];
        double[] studentMaxVisits = new double[sumStudents];

        for (int currentStudent = 0; currentStudent < sumStudents; currentStudent++) {
            int sumVisitsStudent = Integer.parseInt(scanner.nextLine()); //брой посещения на дадения студент

            double allBonus = sumVisitsStudent * 1.0 /sumCourses;
            allBonus *= (5 + coursesBonus);
            allBonus = Math.round(allBonus);
            studentMaxBonus[currentStudent] = allBonus;
            studentMaxVisits[currentStudent] = sumVisitsStudent;
        }
        Arrays.sort(studentMaxBonus);
        Arrays.sort(studentMaxVisits);

        System.out.printf("Max Bonus: %.0f.%n", studentMaxBonus[studentMaxBonus.length - 1]);
        System.out.printf("The student has attended %.0f lectures.", studentMaxVisits[studentMaxVisits.length - 1]);
    }
}
