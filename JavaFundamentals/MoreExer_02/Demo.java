package MoreExer_02;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nRows = Integer.parseInt(scanner.nextLine());

        boolean isOpened = false;
        boolean isBalanced = true;

        for (int currentRow = 1; currentRow <= nRows; currentRow++) {
            String input = scanner.nextLine();

            if (input.equals("(")){
                if (!isOpened){
                    isOpened = true;
                }else {
                    isBalanced = false;
                }

            }

            if (input.equals(")")){
                if  (isOpened){
                    isOpened = false;
                }else {
                    isBalanced = false;
                }
            }

        }
        if (isBalanced && !isOpened){
            System.out.println("BALANCED");
        }else {
            System.out.println("UNBALANCED");
        }

    }
}
