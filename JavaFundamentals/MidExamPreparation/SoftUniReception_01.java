package MidExamPreparation;

import java.util.Scanner;

public class SoftUniReception_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());
        int studentsQuestions = Integer.parseInt(scanner.nextLine());

        int allAnswerPerHour = firstEmployee + secondEmployee + thirdEmployee;
        int workHourCounter = 0;

        while (studentsQuestions > 0){
            workHourCounter++;

            if (workHourCounter % 4 != 0){
                studentsQuestions -= allAnswerPerHour;
            }

        }
        System.out.printf("Time needed: %dh.", workHourCounter);
    }
}
