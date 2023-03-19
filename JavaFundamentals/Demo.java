import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sumStudents = Integer.parseInt(scanner.nextLine());   //брой студенти
        int sumCourses = Integer.parseInt(scanner.nextLine());    //общ брой лекций
        int coursesBonus = Integer.parseInt(scanner.nextLine());  //допълнителен бонус

        double maxBonus = Double.MIN_VALUE;
        double visitsStudent = 0.0;

        for (int currentStudent = 0; currentStudent < sumStudents; currentStudent++) {
            int sumVisitsStudent = Integer.parseInt(scanner.nextLine()); //брой посещения на дадения студент

            double bonus = sumVisitsStudent * 1.0 / sumCourses;
            bonus = Math.round(bonus * (5 + coursesBonus));

            if (maxBonus <= bonus){
                maxBonus = bonus;
                visitsStudent = sumVisitsStudent;
            }
        }

        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %.0f lectures.", visitsStudent);
    }
}
