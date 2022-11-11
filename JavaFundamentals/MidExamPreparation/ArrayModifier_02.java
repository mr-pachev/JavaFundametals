package MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArray = Arrays.stream(scanner.nextLine()
                                .split(" "))
                                .mapToInt(Integer::parseInt)
                                 .toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")){
            String[] inputArr = input.split(" ");

            String command = inputArr[0]; //въведената команда


            if (command.equals("swap")){
                int firstIndex = Integer.parseInt(inputArr[1]); //първи индекс по задание
                int secondIndex = Integer.parseInt(inputArr[2]); //втори индекс по задание

                int elementOne = numArray[firstIndex]; //взимане на първи елемент от масива numArr
                int elementTwo = numArray[secondIndex]; //взимаке на втори елемент от масива numArr
                int bufferElement = numArray[firstIndex];
                numArray[firstIndex] = elementTwo;
                numArray[secondIndex] = bufferElement;

            }else  if (command.equals("multiply")){
                int firstIndex = Integer.parseInt(inputArr[1]); //първи индекс по задание
                int secondIndex = Integer.parseInt(inputArr[2]); //втори индекс по задание

                int elementOne = numArray[firstIndex]; //взимане на първи елемент от масива numArr
                int elementTwo = numArray[secondIndex]; //взимаке на втори елемент от масива numArr
                int bufferElement = numArray[firstIndex];
                bufferElement = elementOne * elementTwo;
                numArray[firstIndex] = bufferElement;

            }else if (command.equals("decrease")){
                for (int index = 0; index <= numArray.length - 1; index++) {
                    numArray[index] -= 1;
                }
            }

             input = scanner.nextLine();
        }

        for (int i = 0; i <= numArray.length - 1; i++) {
            int currentElement = numArray[i];
            if (i == 0){
                System.out.printf("%d", currentElement);
            }else {
                System.out.printf(", %d", currentElement);
            }
        }
    }
}
