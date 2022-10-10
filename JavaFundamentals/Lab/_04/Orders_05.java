package Lab._04;

import java.util.Scanner;

public class Orders_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        double quantity = Integer.parseInt(scanner.nextLine());

        switch (product) {
            case "coffee": {
                calculateCoffee(quantity);
                break;
            }
            case "water": {
                calculateWater(quantity);
                break;
            }
            case "coke": {
                calculateCoke(quantity);
                break;
            }
            case "snacks": {
                calculateSnacks(quantity);
                break;
            }
        }
    }

    public static void calculateCoffee(double doseCoffee) {
        double coffeePrice = doseCoffee * 1.50;
        System.out.printf("%.2f", coffeePrice);
    }

    public static void calculateWater(double doseWate) {
        double waterPrice = doseWate * 1.00;
        System.out.printf("%.2f", waterPrice);
        ;
    }

    public static void calculateCoke(double doseCoke) {
        double cokePrice = doseCoke * 1.40;
        System.out.printf("%.2f", cokePrice);
    }

    public static void calculateSnacks(double doseSnacks) {
        double snacksPrice = doseSnacks * 2.00;
        System.out.printf("%.2f", snacksPrice);
    }
}