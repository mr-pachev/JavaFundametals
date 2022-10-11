package MoreExer_01;

import java.util.Scanner;

public class SortNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double c = Double.parseDouble(scanner.nextLine());

        double minNum = 0;
        double averageNum = 0;
       double maxNum = 0;

        if (a > b && a > c) {
            maxNum = a;
            if (b > c) {
                minNum = c;
                averageNum = b;
            } else {
                minNum = b;
                averageNum = c;
            }
        }else if (b > a && b > c) {
            maxNum = b;
            if (a > c) {
                minNum = c;
                averageNum = a;
            } else {
                minNum = a;
                averageNum = c;
            }
        }else if (c > a && c > b) {
            maxNum = c;
            if (a > b) {
                minNum = b;
                averageNum = a;
            } else {
                minNum = a;
                averageNum = b;
            }
        }

        System.out.printf("%.0f%n", maxNum);
        System.out.printf("%.0f%n", averageNum);
        System.out.printf("%.0f%n", minNum);
    }
}

