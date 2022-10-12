package MoreExer_02;

import java.util.Scanner;

public class FloatingEquality_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numberA = Double.parseDouble(scanner.next());
        double numberB = Double.parseDouble(scanner.next());

        double eps = 0.000001;

        double diff = Math.abs(numberA - numberB);

        if (diff > eps){
            System.out.println("False");
        }else {
            System.out.println("True");
        }

    }
}
