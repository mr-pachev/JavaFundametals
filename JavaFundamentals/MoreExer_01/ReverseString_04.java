package MoreExer_01;

import java.util.Scanner;

public class ReverseString_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        for (int i = input.length()-1; i >= 0; i--) {
            String inverst = input.split("")[i];
            System.out.printf("%s", inverst);
        }

    }
}
