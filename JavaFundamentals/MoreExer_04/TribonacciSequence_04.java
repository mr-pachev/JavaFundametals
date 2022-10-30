package MoreExer_04;

import java.util.Scanner;

public class TribonacciSequence_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        printTrib(num);
    }

    static int printTribRec(int n) {

        if (n == 0 || n == 1 || n == 2)
            return 0;

        if (n == 3)
            return 1;
        else

            return printTribRec(n - 1) +
                    printTribRec(n - 2) +
                    printTribRec(n - 3);
    }

    static void printTrib(int n) {
        for (int i = 3; i <= n + 2; i++)
            System.out.print(printTribRec(i)
                    + " ");
    }
}
