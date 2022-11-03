package MoreExer_05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        double timeLeftPlayer = 0;
        double timeRightPlayer = 0;

        for (int indexLeft = 0; indexLeft < numbersList.size() / 2; indexLeft++) {
            int cuurentTime = numbersList.get(indexLeft);

            if (cuurentTime == 0){
                timeLeftPlayer -= 20 * 1.0 / 100 * timeLeftPlayer;
            }else {
                timeLeftPlayer += cuurentTime;
            }
        }

        for (int indexRight = numbersList.size() - 1; indexRight > numbersList.size() / 2; indexRight--) {
            int cuurentTime = numbersList.get(indexRight);

            if (cuurentTime == 0){
                timeRightPlayer -= 20 * 1.0 / 100 * timeRightPlayer;
            }else {
                timeRightPlayer += cuurentTime;
            }
        }

        if (timeLeftPlayer < timeRightPlayer){
            System.out.printf("The winner is left with total time: %.1f", timeLeftPlayer);
        }else if (timeLeftPlayer > timeRightPlayer){
            System.out.printf("The winner is right with total time: %.1f", timeRightPlayer);
        }

    }
}
