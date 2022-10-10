package Exercises._05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeckList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondDeckList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;

        while (!firstDeckList.isEmpty() && !secondDeckList.isEmpty()) {
            int firstDeckCard = firstDeckList.get(0);
            int secondDeckcard = secondDeckList.get(0);

            if (firstDeckCard > secondDeckcard) {
                firstDeckList.add(firstDeckCard);
                firstDeckList.add(secondDeckcard);
                firstDeckList.remove(0);
                secondDeckList.remove(0);
            } else if (secondDeckcard > firstDeckCard) {
                secondDeckList.add(secondDeckcard);
                secondDeckList.add(firstDeckCard);
                secondDeckList.remove(0);
                firstDeckList.remove(0);
            } else if (firstDeckCard == secondDeckcard) {
                firstDeckList.remove(0);
                secondDeckList.remove(0);
            }
        }
        if (firstDeckList.size() > secondDeckList.size()) {
            for (int cards : firstDeckList) {
                sum += cards;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        } else {
            for (int cards : secondDeckList) {
                sum += cards;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }

    }
}


