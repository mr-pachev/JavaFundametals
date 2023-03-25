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

        while (!input.equals("Retire")) {

            String command = input.split(" ")[0];

            switch (command) {

                case "Fire":
                    int indexFire = Integer.parseInt(input.split(" ")[1]);
                    int currentSectionCondition = Integer.parseInt(input.split(" ")[2]);

                    if (isExist(warShip, indexFire)) {
                        int damageSection = warShip.get(indexFire);
                        int damage = currentSectionCondition - damageSection;

                        if (damage <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
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

                    if(isExist(pirateShip, startIndex) && isExist(pirateShip, endIndex)){

                    }

                    break;
                case "Repair":
                    break;
                case "Status":
                    break;
            }

            input = scanner.nextLine();
        }
    }

    public static boolean isExist(List<Integer> list, int index) {
        return (index >= 0 && index < list.size());
    }
}
