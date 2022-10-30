package MoreExer_04;

import java.util.Scanner;

public class CenterPoint_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstPointX = Integer.parseInt(scanner.nextLine());
        int firstPointY = Integer.parseInt(scanner.nextLine());

        int secondPointX = Integer.parseInt(scanner.nextLine());
        int secondPointY = Integer.parseInt(scanner.nextLine());

       if (average(firstPointX, firstPointY) <= average(secondPointX, secondPointY)){
           System.out.printf("(%d, %d)", firstPointX, firstPointY);
       }else {
           System.out.printf("(%d, %d)", secondPointX, secondPointY);
       }

    }
    public static Integer average (int pointX, int pointY){
        int averagePoint = Math.abs(pointX + pointY);
            return averagePoint;
    }
}
