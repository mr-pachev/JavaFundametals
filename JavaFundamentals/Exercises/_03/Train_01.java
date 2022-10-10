package Exercises._03;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Scanner;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wagons = Integer.parseInt(scanner.nextLine());// броя на вагоните цяло число
        int[] wagonsInTrain = new int[wagons]; // масив с дължина броя на вагоните
        int sum = 0;

        for (int i = 0; i < wagons; i++) {// цикъл за запълване на масива с цели числа
            wagonsInTrain[i] = Integer.parseInt(scanner.nextLine());// въвждане на цяло число от конзолата в конкретние индекс от масива
            System.out.print(wagonsInTrain[i] + " ");
            sum += wagonsInTrain[i];// сумиране на стойностите от конкретниу индекс
        }
        System.out.println();
        System.out.println(sum);
    }
}

