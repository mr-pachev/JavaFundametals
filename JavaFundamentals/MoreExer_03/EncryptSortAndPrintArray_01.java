package MoreExer_03;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numRows = Integer.parseInt(scanner.nextLine());

        int[] sumOfNames = new int [numRows]; //масив за сумата от буквите на имената

        for (int currentRow = 1; currentRow <= numRows; currentRow++) {

            String currentName = scanner.nextLine(); //текущото име

            char currentChar = ' ';
            int sumChar = 0;

            for (int currentLetterr = 0; currentLetterr < currentName.length(); currentLetterr++) { //обхожда всяка буква(всеки индекс) на масива
                currentChar = currentName.charAt(currentLetterr);

                    if (currentChar == 65 || currentChar == 97
                    || currentChar == 69 || currentChar == 101
                    || currentChar == 73 || currentChar == 105
                    || currentChar == 79 || currentChar == 111
                    || currentChar == 85 || currentChar == 117){
                       sumChar += currentChar * currentName.length();
                    }else {
                        sumChar += currentChar / currentName.length();
                    }

            }
            sumOfNames[currentRow - 1] = sumChar;
        }
        Arrays.sort(sumOfNames); //метод за сортиране

        for (int currentResult : sumOfNames){
            System.out.println(currentResult);
        }

    }
}
