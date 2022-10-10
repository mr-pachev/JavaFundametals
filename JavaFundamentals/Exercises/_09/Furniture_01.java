package Exercises._09;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = ">>(?<furnitureName>[A-Za-z]+)<<(?<price>[0-9]+(.[0-9]+)*)!(?<quantity>[0-9]+)";

        double allPrice = 0;
        System.out.println("Bought furniture:");

        while (!input.equals("Purchase")){
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String furnitureName = matcher.group("furnitureName");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                allPrice += price * quantity;

                System.out.println(furnitureName);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total money spend: %.2f", allPrice);
    }
}
