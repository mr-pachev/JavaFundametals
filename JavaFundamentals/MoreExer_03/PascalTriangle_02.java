package MoreExer_03;

import java.util.Scanner;

public class PascalTriangle_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int row = 1; row <= n; row++) { //принтира редовете

            int constant = 1;
            for (int column = 1; column <= row; column++) { //принтира колоните
                System.out.printf("%d ", constant);
                constant = constant * (row - column) / column;
            }
            System.out.println();

        }


    }
}
