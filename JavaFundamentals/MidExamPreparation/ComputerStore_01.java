package MidExamPreparation;

import java.util.Scanner;

public class ComputerStore_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        double sumPartsPriceWidthOut = 0;
        double taxes = 0;
        double allGrossPrice = 0;

        while (!command.equals("special") && !command.equals("regular")) {
            double pricePart = Double.parseDouble(command);
            if (pricePart < 0) {
                System.out.println("Invalid price!");
                command = scanner.nextLine();
                continue;
            }

            sumPartsPriceWidthOut += pricePart;

            taxes = sumPartsPriceWidthOut * 0.2;
            allGrossPrice = sumPartsPriceWidthOut + taxes;

            command = scanner.nextLine();
        }

        if (allGrossPrice == 0) {
            System.out.println("Invalid order!");
        } else if (command.equals("special")) {
            double discount = allGrossPrice * 0.1;
            allGrossPrice -= discount;
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", sumPartsPriceWidthOut);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$%n", allGrossPrice);
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", sumPartsPriceWidthOut);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$%n", allGrossPrice);
        }
    }
}
