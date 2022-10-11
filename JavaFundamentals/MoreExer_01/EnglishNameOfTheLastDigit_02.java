package MoreExer_01;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class EnglishNameOfTheLastDigit_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        writingDigit(number);

    }

    public static void writingDigit(int currentNum) {
        int num = currentNum % 10; //отделяме последната цифра

        if (num == 0) {
            System.out.println("zero");
        } else if (num == 1) {
            System.out.println("one");
        } else if (num == 2) {
            System.out.println("two");
        } else if (num == 3) {
            System.out.println("tree");
        } else if (num == 4) {
            System.out.println("four");
        } else if (num == 5) {
            System.out.println("five");
        } else if (num == 6) {
            System.out.println("six");
        } else if (num == 7) {
            System.out.println("seven");
        } else if (num == 8) {
            System.out.println("eight");
        } else if (num == 9) {
            System.out.println("nine");
        }
    }
}
