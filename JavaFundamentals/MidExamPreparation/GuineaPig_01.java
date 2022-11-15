package MidExamPreparation;

import java.util.Scanner;

public class GuineaPig_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double quantityFood = Double.parseDouble(scanner.nextLine()); //количество храна
        quantityFood *= 1000;
        double quantityHay = Double.parseDouble(scanner.nextLine()); //количество сено
        quantityHay *= 1000;
        double quantityCover = Double.parseDouble(scanner.nextLine()); //количество покривало
        quantityCover *= 1000;
        double weight = Double.parseDouble(scanner.nextLine()); //тегло
        weight *= 1000;

        boolean noMore = false;

        for (int currentDay = 1; currentDay <= 30; currentDay++) { //отброява дните от месеца
            quantityFood -= 300;

            if (quantityFood >= 0 && quantityHay >= 0 && quantityCover >= 0) { //проверка дали трите неща са в наличност
                if (currentDay % 2 == 0) { //всеки втори ден
                    double hay = 5 * 1.0 / 100 * quantityFood; //количеството сено, което се дава всеки втори ден
                    quantityHay -= hay;
                }
                if (currentDay % 3 == 0) { //всеки трети ден
                    double cover = weight / 3; //количествот покривало, което се дава всеки трети ден
                    quantityCover -= cover;
                }
            }else {
                noMore = true;
                break;
            }

        }

        if (noMore){
            System.out.println("Merry must go to the pet store!");
        }else {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", quantityFood / 1000, quantityHay / 1000, quantityCover / 1000);
        }
    }
}
