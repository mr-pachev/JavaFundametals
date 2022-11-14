package MidExamPreparation;

import java.util.Scanner;

public class CounterStrike_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startEnergy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int counterWinGames = 0; //брояч спечелени игри
        boolean noEnergy = false;

        while (!input.equals("End of battle")){
            int currentEnergy = Integer.parseInt(input); //текущо разстояние и нужка енергиа за него

            if (startEnergy >= currentEnergy){ //проверка дали битката е спечелена
                counterWinGames++;

                if(counterWinGames % 3 == 0){ //проверка дали спечелената битка е трета по ред
                    startEnergy += counterWinGames;
                }
                    startEnergy -= currentEnergy;

            }else {
                noEnergy = true;
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", counterWinGames, startEnergy);
                break;
            }

            input = scanner.nextLine();
        }
        if(!noEnergy){
            System.out.printf("Won battles: %d. Energy left: %d",counterWinGames, startEnergy);
        }
    }
}
