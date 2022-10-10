package MidExamPreparation;

import java.util.Scanner;

public class CookingMasterclass_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget= Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine()); // брой студенти

        double packageFlour = Double.parseDouble(scanner.nextLine()); // цена пакет брашно
        int neededPackageFlour = students;

        double singleEag = Double.parseDouble(scanner.nextLine()); // цена на една яйце
        double eagsForOneStudent = singleEag * 10;

        double singleApron = Double.parseDouble(scanner.nextLine()); // цена на една престилка

        if (neededPackageFlour % 5 == 0){
            int count = neededPackageFlour / 5;
            for (int i = 1; i <= count; i++) {
                neededPackageFlour -= 1;
            }
        }
        double allPriceFlour =  packageFlour * neededPackageFlour; // цена брашно за всички студенти
        double allPriceEags = students * eagsForOneStudent; // цена на яйцата за всички студенти

        double discount = Math.ceil(students * 0.2);
        double allPriceApron = singleApron * (students + discount); // цена на престилките за всички студенти плюс отстъпката

        double allSumNeed = allPriceFlour + allPriceEags + allPriceApron;

        if (allSumNeed <= budget){
            System.out.printf("Items purchased for %.2f$.%n", allSumNeed);
        }else {
            System.out.printf("%.2f$ more needed.", allSumNeed - budget);
        }

    }
}
