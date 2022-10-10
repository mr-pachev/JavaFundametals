package MidExamPreparation;

import java.util.Scanner;

public class MuOnline_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrInput = scanner.nextLine().split("\\|");
        String arrCurrent = "";
        String command = "";
        int num = 0;
        int healt = 100;
        int counterBit = 0;

        boolean isDead = false;

        for (int i = 0; i <= arrInput.length - 1; i++) {
            arrCurrent = arrInput[i];
            command = arrCurrent.split(" ")[0];
            num = Integer.parseInt(arrCurrent.split(" ")[1]);

            switch (command) {
                case "potion":
                    healt += num;

                    if (healt > 100) {
                        healt -= num;
                        System.out.printf("You healed for %d hp.%n", 100 - healt);
                        healt = 100;
                    }else {
                        System.out.printf("You healed for %d hp.%n", num);
                    }
                    System.out.printf("Current health: %d hp.%n", healt);
                    break;

                case "chest":
                    System.out.printf("You found %d bitcoins.%n", num);
                    counterBit += num;
                    break;

                default:
                    healt -= num;
                    if (healt > 0) {
                        System.out.printf("You slayed %s.%n", command);
                    } else if (healt <= 0) {
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d%n", i + 1);
                        isDead = true;
                        break;
                    }
                    break;
            }
            if (isDead) {
                break;
            }
        }
        if (!isDead) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", counterBit);
            System.out.printf("Health: %d%n", healt);
        }
    }
}
