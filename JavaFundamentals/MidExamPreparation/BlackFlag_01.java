package MidExamPreparation;

import java.util.Scanner;

public class BlackFlag_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOfThePlunder = Integer.parseInt(scanner.nextLine()); //дни за плячкосване
        int dailyPlunder = Integer.parseInt(scanner.nextLine()); //размер на дневната плячка
        int expendedPlunder = Integer.parseInt(scanner.nextLine()); //очаквана плячка

        double collectedPlunder = 0; //събрана плячка

        for (int day = 1; day <= daysOfThePlunder; day++) {

            collectedPlunder += dailyPlunder; //събиране на дневната плячка

            if (day % 3 == 0) { //
                double bonus = 50 * 1.0 / 100 * dailyPlunder;
                collectedPlunder += bonus;
            }

            if (day % 5 == 0) {
                double diff = 30 * 1.0 / 100 * collectedPlunder;
                collectedPlunder -= diff;
            }
        }

        if (collectedPlunder >= expendedPlunder) { //просерка дали е събрана очакваната плячка
            System.out.printf("Ahoy! %.2f plunder gained.", collectedPlunder);
        } else {
            double percent = collectedPlunder * 100 / expendedPlunder;
            System.out.printf("Collected only %.2f%% of the plunder.", percent);
        }

    }
}
