package MoreExer_04;

import java.util.Scanner;

public class CenterPoint_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstPointX = Integer.parseInt(scanner.nextLine());
        int firstPointY = Integer.parseInt(scanner.nextLine());

        int secondPointX = Integer.parseInt(scanner.nextLine());
        int secondPointY = Integer.parseInt(scanner.nextLine());

       int averageFirstPoint = Math.abs(firstPointX + firstPointY);
       int averageSecondPoint = Math.abs(secondPointX + secondPointY);

       if (averageFirstPoint <= averageSecondPoint){
           System.out.printf("(%d, %d)", firstPointX, firstPointY);
       }else {
           System.out.printf("(%d, %d)", secondPointX, secondPointY);
       }

    }
}
