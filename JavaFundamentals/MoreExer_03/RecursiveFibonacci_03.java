package MoreExer_03;

import java.util.Scanner;

public class RecursiveFibonacci_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(fibonacci(n));

    }
    public static Integer fibonacci(int num) {
        if (num == 0){
            return 0;
        }else if (num == 1){
            return 1;
        }else {
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }
}
