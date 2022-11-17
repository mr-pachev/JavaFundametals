package MidExamPreparation;

import java.util.Scanner;

public class BonusScoringSystem_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sumStudents = Integer.parseInt(scanner.nextLine()); //брой ученици
        int numberOfTheLectures = Integer.parseInt(scanner.nextLine()); //номер на лекцийте
        int additionalBonus = Integer.parseInt(scanner.nextLine()); //допълнителен бонус

        double alLBonus = 0; //общ бонус
        double studentMaxBonus = Double.MIN_VALUE;
        int studentAttendance = 0;

        for (int currentStudent = 1; currentStudent <= sumStudents; currentStudent++) {
            int attendance = Integer.parseInt(scanner.nextLine()); //присъствие на всеки ученик

            alLBonus = Math.ceil((attendance * 1.0/ numberOfTheLectures) * (5 + additionalBonus));
            if (alLBonus >= studentMaxBonus){
                studentMaxBonus = alLBonus;
                studentAttendance = attendance;
            }

        }
        System.out.printf("Max Bonus: %.0f.%n", studentMaxBonus);
        System.out.printf("The student has attended %d lectures.", studentAttendance);
    }
}
