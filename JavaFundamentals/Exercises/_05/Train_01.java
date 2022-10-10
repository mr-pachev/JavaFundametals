package Exercises._05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagonsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxPassengersInWagon = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String command = input.split(" ")[0]; // взимане на команда(ако я има), която винаги е на индекс 0

            if (command.equals("Add")) { // проверка има ли команда Add -> добавяну на нов вагон с пътници на края на списъка
                int wagonsAdd = Integer.parseInt(input.split(" ")[1]); // броя пътници в добавения вагон
                wagonsList.add(wagonsAdd);
            } else {
                int currentWagon = 0;
                int addPassengers = Integer.parseInt(input.split(" ")[0]); // добавените нови пътници за разпределение по вагоните
                for (int i = 0; i < wagonsList.size(); i++) { // обхождане на всеки елемент от  списъка
                    currentWagon = wagonsList.get(i);
                    if (currentWagon + addPassengers <= maxPassengersInWagon) { // проверка дали сбора на текущите пътници и добавените е по-малък или равен от въведения максимален брой
                        wagonsList.set(i, currentWagon + addPassengers);
                        break;
                    }
                }
            }

            input = scanner.nextLine();
        }
        for (int num : wagonsList) {
            System.out.print(num + " ");
        }
    }
}
