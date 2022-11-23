package MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShipList = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> warShipList = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maximumHealth = Integer.parseInt(scanner.nextLine()); //максимално здраве на пираткия кораб
        double minimumHealth = 0.2 * maximumHealth; //праг на здраве на секцията
        boolean isRetrite = true;

        String input = scanner.nextLine();

        while (!input.equals("Retire")) {
            String[] inputArr = input.split(" ");
            String command = inputArr[0]; //команда

            if (command.equals("Fire")) { //нападай
                int indexWarShip = Integer.parseInt(inputArr[1]); //индекса на военния кораб от който ще се вадят щетите
                int damageWarShip = Integer.parseInt(inputArr[2]); //елемнета, конто ще се извади от дадения индекс

                if (indexWarShip >= 0 && indexWarShip <= warShipList.size() - 1) { //проверка дали индекса д валиден
                    int warShipElement = warShipList.get(indexWarShip); //елемента от който ще вадим

                    warShipElement -= damageWarShip;

                    if (warShipElement <= 0) { //проверка дали кораба е потопен
                        System.out.println("You won! The enemy ship has sunken.");
                        isRetrite = false;
                        break;
                    } else {
                        warShipList.set(indexWarShip, warShipElement);
                    }
                }
            } else if (command.equals("Defend")) { //защита
                int startIndex = Integer.parseInt(inputArr[1]); //индекс, от които ще вадим щетата
                int endIndex = Integer.parseInt(inputArr[2]); //индекс, до конто ще се вади щетата
                int damage = Integer.parseInt(inputArr[3]); //щета

                if (startIndex >= 0 && startIndex <= pirateShipList.size() - 1
                        && endIndex >= 0 && endIndex <= pirateShipList.size() - 1) { //просерка дали са валидни индексите
                    int currentElement = 0; //текущия елемент за просерка

                    for (int indexPirateShip = startIndex; indexPirateShip <= endIndex; indexPirateShip++) {
                        currentElement = pirateShipList.get(indexPirateShip); //промяна на дадения елемент след нападението

                        currentElement -= damage;
                        if (currentElement <= 0) { //просерка дали кораба е потопен
                            System.out.println("You lost! The pirate ship has sunken.");
                            isRetrite = false;
                            break;
                        } else {
                            pirateShipList.set(indexPirateShip, currentElement); //промяна на дадения елемент след нападението
                        }
                    }
                }
            } else if (command.equals("Repair")) { //поправи
                int indexRepair = Integer.parseInt(inputArr[1]); //дадения индекс за поправка
                int bonusHealth = Integer.parseInt(inputArr[2]); //бонус здраве

                if (indexRepair >= 0 && indexRepair <= pirateShipList.size() - 1) { //проверка дали индекса е валиден
                    int currentElement = 0; //текущ елемент от списъка

                    currentElement = pirateShipList.get(indexRepair);
                    currentElement += bonusHealth;

                    if (currentElement > maximumHealth) { //проверка дали добавеното здраве не превишава маскималното здраве
                        currentElement = maximumHealth;
                    }
                    pirateShipList.set(indexRepair, currentElement); //промяна на елемента след добавеното здраве

                }
            } else if (command.equals("Status")) { //секций за ремонт
                int currentElement = 0; //текущ елемент от списъка
                int counter = 0; //брояч на секцийте за ремонт

                for (int index = 0; index <= pirateShipList.size() - 1; index++) {
                    currentElement = pirateShipList.get(index);

                    if (currentElement < minimumHealth) { //проверка дали дадената секция е за ремонт
                        counter++;
                    }
                }
                System.out.printf("%d sections need repair.%n", counter);
            }

            input = scanner.nextLine();
        }

        if (isRetrite) {
            int countPirateShipElement = 0; //сума на елементит
            int countWarShipElement = 0;

            for (int index = 0; index <= pirateShipList.size() - 1; index++) {
                countPirateShipElement += pirateShipList.get(index);
            }
            for (int index = 0; index <= warShipList.size() - 1; index++) {
                countWarShipElement += warShipList.get(index);
            }

            System.out.printf("Pirate ship status: %d%n", countPirateShipElement);
            System.out.printf("Warship status: %d%n", countWarShipElement);
        }
    }
}
