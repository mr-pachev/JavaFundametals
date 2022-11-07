package MoreExer_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        List<Integer> originDrumList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> drumsList = new ArrayList<>();
        for (int element : originDrumList) {
            drumsList.add(element);
        }

        String input = scanner.nextLine();

        while (!input.equals("Hit it again, Gabsy!")){

            int punch = Integer.parseInt(input.split(" ")[0]); //сила на удъра

            for (int index = 0; index <= drumsList.size() - 1; index++) { //обхожда листа с барабаните
                int currentElement = drumsList.get(index); //текущия барабан


                if (currentElement > 0){ //проверка дали дадения барабан може да поеме удар или да се закупи друг
                    int drumPrice = (originDrumList.get(index)) * 3; //цена за нов барабан

                    if (currentElement > punch) { //проверка дали барабана може да поеме конкретния удър
                        currentElement -= punch;
                        drumsList.set(index, currentElement);
                    } else if (budget >= drumPrice){ //проверка дали има бюджет за закупуване на конкретния барабан
                        drumsList.set(index, originDrumList.get(index)); //замяна на счупения барабан със същия нов
                        budget -= drumPrice;
                    }
                    else {
                        drumsList.remove(drumsList.get(index)); //премахване на барабана от листа с резултатите
                        originDrumList.remove(originDrumList.get(index)); //премахване на бараба и от оригиналния лист за изчисляване цената на нов барабан
                        index--;
                    }
                }
            }
            input = scanner.nextLine();
        }

       for (int drum : drumsList) {
           System.out.printf("%d ", drum);
       }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", budget);
    }
}
