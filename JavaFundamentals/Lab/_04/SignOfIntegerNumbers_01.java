package Lab._04;

import java.util.Scanner;

public class SignOfIntegerNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        printNum(number);
    }
    public static void printNum(int n){
        if (n > 0){
            System.out.printf("The number %d is positive.", n);
        }else if (n < 0){
            System.out.printf("The number %d is negative.", n);
        }else {
            System.out.println("The number 0 is zero.");
        }
    }
}
