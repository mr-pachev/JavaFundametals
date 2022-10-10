package Exercises._05;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine(); // прочитане на входните данни
        int sum = 0;

        int specialNum = Integer.parseInt((input).split(" ")[0]); // взимане на индекс 0 от воходните данни за BombNumber
        int powerOfBomb = Integer.parseInt((input).split(" ")[1]); // взимане на индекс 1 от входните данни за силата на бомбата



        while (numList.contains(specialNum)) { // проверява с помоща на метода .contains дали в списъка се съдържа(още) specialNum
            int indexSpecialNum = numList.indexOf(specialNum); // определяне индекса на BombNumber с помоща на метода indexOf
            int left = Math.max(0, indexSpecialNum - powerOfBomb); // взимане на индекса за началото от поредицата елементи за премахване.
            // С помоща на метода Math.max определяме началната точка включително, като извадим индекса на BombNumber и силата на бомбата (poweOfBomb)

            int right = Math.min(indexSpecialNum + powerOfBomb, numList.size()-1); // взимане на индекса за края от поредицата за премахване
            // С помоща на метода Math.mix определяме крайната точка включително, като съберем индекса на BombNumber и силата на бомбата (poweOfBomb).
            // Сборът им по подразбиране трябва да е по-малък от размера на списъка (numList()-1)

            for (int i = right; i >= left; i--) {
                numList.remove(i);
            }
        }
        for (int i = 0; i < numList.size(); i++) {
            sum += numList.get(i);
        }
        System.out.println(sum);
    }
}
