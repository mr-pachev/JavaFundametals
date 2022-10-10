package Exercises._05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> guests = new ArrayList<>();

        for (int i = 1; i <= n; i++) { // цикъл според броя команди
            String input = scanner.nextLine();

            String names = input.split(" ")[0]; // взимане на името на госта от input
            String command = input.split(" ")[2]; // проверка госта дали ще ходи или няма да ходи

            if (command.equals("going!")) {
                if (guests.contains(names)) { // проверка дали името е в списъка
                    System.out.printf("%s is already in the list!%n", names);
                } else {
                    guests.add(names);
                }
            } else if (command.equals("not")) {
                if (guests.contains(names)) {
                    guests.remove(names);
                } else {
                    System.out.printf("%s is not in the list!%n", names);
                }
            }
        }
        for (String names : guests){
            System.out.println(names);
        }
    }
}
