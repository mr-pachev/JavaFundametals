package MoreExer_01;

import java.util.Scanner;

public class GamingStore_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String game = scanner.nextLine();

        double gamePrice = 0; //цената на текущата игра
        double allSumBayGames = 0; //общо изхарбена сума за купуване на игри

        while (!game.equals("Game Time")) {
            gamePrice = 0;

            switch (game) {
                case "OutFall 4":
                    gamePrice = 39.99;
                    break;

                case "CS: OG":
                    gamePrice = 15.99;
                    break;

                case "Zplinter Zell":
                    gamePrice = 19.99;
                    break;

                case "Honored 2":
                    gamePrice = 59.99;
                    break;

                case "RoverWatch":
                    gamePrice = 29.99;
                    break;

                case "RoverWatch Origins Edition":
                    gamePrice = 39.99;
                    break;

                default:
                    System.out.println("Not Found");
                    break;
            }

            if (budget >= gamePrice){ //проверка дали бюджета е достатъчен за купуване на текущата игра
                budget -= gamePrice;
                allSumBayGames+= gamePrice;
                System.out.printf("Bought %s%n", game);
            }else {
                System.out.println("Too Expensive"); //котато играта струва повече от колкото имаме
            }

            game = scanner.nextLine();
        }

        if (budget > 0){ //проверка дали бюджета е свършил
            System.out.printf("Total spent: $%.2f. ", allSumBayGames);
            System.out.printf("Remaining: $%.2f", budget);
        }else {
            System.out.println("Out of money!");
        }
    }
}
