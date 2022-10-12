package MoreExer_02;

import java.util.Scanner;

public class RefactoringPrimeChecker_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int endNum = Integer.parseInt(scanner.nextLine()); //карй на диапазона за проверка

        for (int startNum = 2; startNum <= endNum; startNum++) { //обхожда диапазона за проверка
            boolean simpleNumber = true;

            for (int currentNum = 2; currentNum < startNum; currentNum++) { //проверка текущото число дали е просто число
                if (startNum % currentNum == 0){
                    simpleNumber = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", startNum, simpleNumber);
        }

    }
}
