package Exercises._07;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materialsMap = new LinkedHashMap<>();// мап, който съдържа готовите елементи
        materialsMap.put("shards", 0);
        materialsMap.put("fragments", 0);
        materialsMap.put("motes", 0);

        Map<String, Integer> trashMap = new LinkedHashMap<>();// мап, който ще съдържа ненужния материал-боклука

        boolean isWin = false;
        while (!isWin) {
            String incoming = scanner.nextLine(); //входяще данни
            String[] resource = incoming.split(" "); //масив от входящите данни с разделител интервал

            for (int i = 0; i <= resource.length - 1; i += 2) { //обхождане на първи ред от входните данни
                int quantity = Integer.parseInt(resource[i]);
                String material = resource[i + 1].toLowerCase();

                if (materialsMap.containsKey(material)) { //проверка дали входния материал е нужен-има го в мапа и само добавяме стойността
                    int currentQuantity = materialsMap.get(material);
                    materialsMap.put(material, currentQuantity + quantity);
                } else {
                    if (!trashMap.containsKey(material)) {// проверка дали боклука вече го има в мапа и се добавя самостойността
                        trashMap.put(material, quantity);// материала-боклук не същестува в мапа и се добавя
                    } else {
                        int current = trashMap.get(material);
                        trashMap.put(material, current + quantity);
                    }
                }
                // проверка дали нужния тип материал е стигнал стойност 250 за победа
                if (materialsMap.get("shards") >= 250) {
                    System.out.println("Shadowmourne obtained!");
                    materialsMap.put("shards", materialsMap.get("shards") - 250);
                    isWin = true;
                    break;
                } else if (materialsMap.get("fragments") >= 250) {
                    System.out.println("Valanyr obtained!");
                    materialsMap.put("fragments", materialsMap.get("fragments") - 250);
                    isWin = true;
                    break;
                } else if (materialsMap.get("motes") >= 250) {
                    System.out.println("Dragonwrath obtained!");
                    materialsMap.put("motes", materialsMap.get("motes") - 250);
                    isWin = true;
                    break;
                }
            }

            if (isWin) {
                break;
            }
        }
        for (Map.Entry<String, Integer> entry : materialsMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : trashMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

    }
}
