package MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        int moves = 1; //поредността на ходовете

        while (!command.equals("end")) {
            int firstIndex = Integer.parseInt(command.split(" ")[0]);
            int secondIndex = Integer.parseInt(command.split(" ")[1]);



            for (int index = 0; index <= numbersList.size() - 1; index++) {

                if ((isValidIndex(firstIndex, numbersList)) && (isValidIndex(secondIndex, numbersList))
                        && isDuplication(firstIndex, secondIndex)) { //проверка дали индекса е валиден и дали двата индекса са различни

                    if (isEquals(firstIndex, secondIndex, numbersList)) {
                        String firstElement = numbersList.get(index);
                        String secondElement = numbersList.get(index);

                        numbersList.remove(firstElement);
                        numbersList.remove(secondElement);
                        System.out.printf("Congrats! You have found matching elements - %s!%n", firstElement);
                    } else {
                        System.out.println("Try again!");
                    }

                } else {
                    int positionInsert = numbersList.size() / 2;
                    String elementInsert = "-" + moves + "a";
                    numbersList.add(positionInsert, elementInsert);
                    numbersList.add(positionInsert + 1, elementInsert);
                    System.out.println("Invalid input! Adding additional elements to the board");
                }
                break;

            }

            if (numbersList.isEmpty()){
                System.out.printf("You have won in %d turns!", moves);
                break;
            }

            moves++;
            command = scanner.nextLine();
        }
        if (!numbersList.isEmpty()){
            System.out.println("Sorry you lose :(");
            for (String element : numbersList){
                System.out.printf("%s ", element);
            }
        }

    }

    //проверка дали идекса е валиден
    public static boolean isValidIndex(int index, List<String> listForCheck) {
        return index >= 0 && index <= listForCheck.size();
    }

    //проверка дали елементите са равни
    public static boolean isEquals(int firstIndex, int secondIndex, List<String> listForCheck) {
        String firstElement = listForCheck.get(firstIndex);
        String secondElement = listForCheck.get(secondIndex);

        return firstElement.equals(secondElement);
    }

    //проверка дали два индекса са ралични
    public static boolean isDuplication(int one, int twoo) {
        return one != twoo;
    }
}
