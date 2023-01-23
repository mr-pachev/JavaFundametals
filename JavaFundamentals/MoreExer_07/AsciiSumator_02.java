package MoreExer_07;

import java.util.Scanner;

public class AsciiSumator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstBorder = scanner.nextLine().charAt(0);
        char secondBorder = scanner.nextLine().charAt(0);

        String[] symbolsArr = scanner.nextLine().split("");

        int sum = 0;

        for (int i = 0; i < symbolsArr.length; i++) {

            char currentSymbol = symbolsArr[i].charAt(0);

            if(currentSymbol > firstBorder && currentSymbol < secondBorder){
                sum += (int) currentSymbol;
            }
        }
        System.out.println(sum);
    }
}
