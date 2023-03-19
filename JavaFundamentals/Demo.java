import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int bitcoins = 0;
        String[] roomArr = scanner.nextLine().split("\\|");
        int roomCounter = 0;
        int bestRoom = 0;


        for (int i = 0; i < roomArr.length; i++) {
            roomCounter++;
            String command = roomArr[i].split(" ")[0];
            int number = Integer.parseInt(roomArr[i].split(" ")[1]);

            if (command.equals("potion")) {
                if (health + number > 100) {
                    System.out.printf("You healed for %d hp.%n", 100 - health);
                    System.out.println("Current health: 100 hp.");
                    health = 100;
                } else {
                    health += number;
                    System.out.printf("You healed for %d hp.%n", number);
                    System.out.printf("Current health: %d hp.%n", health);
                }

            } else if (command.equals("chest")) {
                bitcoins += number;
                System.out.printf("You found %d bitcoins.%n", number);

            } else {
                health -= number;
                if (health > 0) {
                    System.out.printf("You slayed %s.%n", command);
                } else {
                    System.out.printf("You died! Killed by %s.%n", command);
                    System.out.printf("Best room: %d%n", roomCounter);
                    break;
                }
            }
        }
            if (health > 0){
                System.out.println("You've made it!");
                System.out.printf("Bitcoins: %d%n", bitcoins);
                System.out.printf("Health: %d", health);
            }
    }
}
