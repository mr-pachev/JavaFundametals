package Exercises._07;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Double> productsMap = new LinkedHashMap<>(); //мап съдържащ продукта и цената
        Map<String, Double> productsQuantitiesMap = new LinkedHashMap<>(); //мап съдържащ продукта и количеството

        while (!input.equals("buy")) {
            String productInput = input.split(" ")[0]; //продукт
            double pricePructInout = Double.parseDouble(input.split(" ")[1]); //цена
            double quantitiesProductInput = Double.parseDouble(input.split(" ")[2]); //количество

            productsMap.put(productInput, pricePructInout); //добавяне/заместване на продукта с цената

            if(!productsQuantitiesMap.containsKey(productInput)){ //проверка дали продукта с количеството съществува в мапа
                productsQuantitiesMap.put(productInput, quantitiesProductInput); //добавяне на продукта с количеството в мапа
            }else {
                double currentQuantities = productsQuantitiesMap.get(productInput);
                productsQuantitiesMap.put(productInput, currentQuantities + quantitiesProductInput); //увеличаване количеството на продукта
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Double> entry : productsMap.entrySet()) { //обхождане на мапа с продукта и цената
            String currentProductName = entry.getKey();
            double allSum = entry.getValue() * productsQuantitiesMap.get(currentProductName); //сумиране на стойността на текущия елемент със стойността на елемента от мапа с количеството(кеу и на двата мапа са едни и същи)
            System.out.printf("%s -> %.2f%n", currentProductName, allSum);
        }

    }
}
