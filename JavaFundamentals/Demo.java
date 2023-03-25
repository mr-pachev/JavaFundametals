import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scanner.nextLine().split("\\>"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        List<Integer> warShip = Arrays.stream(scanner.nextLine().split("\\>"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        int maxHealth = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        boolean isEnded = false;

        while (!input.equals("Retire")) {

            String command = input.split(" ")[0];

            switch (command) {

                case "Fire":
                    int indexFire = Integer.parseInt(input.split(" ")[1]);
                    int currentSectionCondition = Integer.parseInt(input.split(" ")[2]);

                    if (isExist(warShip, indexFire)) {
                        int warshipSectionHealth = warShip.get(indexFire);
                        int damage = warshipSectionHealth - currentSectionCondition;

                        if (damage <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            isEnded = true;
                            input = "Retire";
                            continue;
                        } else {
                            warShip.set(indexFire, damage);
                        }
                    }
                    break;

                case "Defend":
                    int startIndex = Integer.parseInt(input.split(" ")[1]);
                    int endIndex = Integer.parseInt(input.split(" ")[2]);
                    int defend = Integer.parseInt(input.split(" ")[3]);

                    if (isExist(pirateShip, startIndex) && isExist(pirateShip, endIndex)) {

                        for (int i = startIndex; i <= endIndex; i++) {
                            int pirateSectionHealth = pirateShip.get(i);
                            int damageCurrentSection = pirateSectionHealth - defend;

                            if (damageCurrentSection <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                isEnded = true;
                                input = "Retire";
                                break;
                            } else {
                                pirateShip.set(i, damageCurrentSection);
                            }
                        }
                    }

                    break;
                case "Repair":
                    int indexRepair = Integer.parseInt(input.split(" ")[1]);
                    int repairHealth = Integer.parseInt(input.split(" ")[2]);

                    if (isExist(pirateShip, indexRepair)) {
                        int repairCurrentSection = pirateShip.get(indexRepair);
                        int repair = repairCurrentSection + repairHealth;

                        if (repair >= maxHealth) {
                            pirateShip.set(indexRepair, maxHealth);
                        } else {
                            pirateShip.set(indexRepair, repair);
                        }
                    }
                    break;

                case "Status":
                    double limit = 20 * 1.0 / 100 * maxHealth;
                    int countSection = 0;

                    for (int i = 0; i < pirateShip.size(); i++) {
                        int currentSectionStatus = pirateShip.get(i);

                        if (currentSectionStatus < limit) {
                            countSection++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", countSection);
                    break;
            }

            input = scanner.nextLine();
        }
        if (!isEnded) {
            System.out.printf("Pirate ship status: %d%nWarship status: %d", sumSectionStatus(pirateShip), sumSectionStatus(warShip));
        }
    }

    public static boolean isExist(List<Integer> list, int index) {
        return (index >= 0 && index < list.size());
    }

    public static Integer sumSectionStatus (List<Integer> list){
        int counterSum = 0;
        for (int i = 0; i < list.size(); i++) {
            counterSum += list.get(i);
        }
        return counterSum;
    }
}
