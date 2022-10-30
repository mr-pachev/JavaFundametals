package MoreExer_04;

import java.util.Scanner;

public class LongerLine_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //координати на точка А
        int firstPointX = Integer.parseInt(scanner.nextLine());
        int firstPointY = Integer.parseInt(scanner.nextLine());
        //координати на точка В
        int secondPointX = Integer.parseInt(scanner.nextLine());
        int secondPointY = Integer.parseInt(scanner.nextLine());

        //координати на точка С
        int thirdPointX = Integer.parseInt(scanner.nextLine());
        int thirdPointY = Integer.parseInt(scanner.nextLine());
        //координати на точка D
        int fourthPointX = Integer.parseInt(scanner.nextLine());
        int fourthPointY = Integer.parseInt(scanner.nextLine());

        //формула за намиране дължина на отсечка в правоъгълна координатна система
        double firstLineAB = Math.sqrt(((secondPointX - firstPointX)*(secondPointX - firstPointX))
                                       + ((secondPointY - fourthPointY)*(secondPointY - fourthPointY)));
        double secondLineCD = Math.sqrt(((fourthPointX - thirdPointX)*(fourthPointX - thirdPointX))
                                       + ((fourthPointY - thirdPointY)));

        if (firstLineAB >= secondLineCD){
            if (average(firstPointX, firstPointY) <= average(secondPointX, secondPointY)){
                System.out.printf("(%d, %d)(%d, %d)", firstPointX, firstPointY, secondPointX, secondPointY);
            }else {
                System.out.printf("(%d, %d)(%d, %d)", secondPointX, secondPointY, firstPointX, firstPointY);
            }
        }else {
            if (average(thirdPointX, thirdPointY) <= average(fourthPointX, fourthPointY)){
                System.out.printf("(%d, %d)(%d, %d)", thirdPointX, thirdPointY, fourthPointX, fourthPointY);
            }else {
                System.out.printf("(%d, %d)(%d, %d)", fourthPointX, fourthPointY, thirdPointX, thirdPointY);
            }
        }

    }
    public static Integer average (int pointX, int pointY){
        return Math.abs(pointX + pointY);
    }


}
