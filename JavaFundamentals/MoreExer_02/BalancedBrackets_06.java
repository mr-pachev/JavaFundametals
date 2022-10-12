package MoreExer_02;

import java.util.Scanner;

public class BalancedBrackets_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nRows = Integer.parseInt(scanner.nextLine());

        int statusClamp = 1;
        String currentClamp = "(";
        boolean isBalance = true;
        boolean isOpened = false; //показва статуса на скобата-последната скоба винаги да е затворена

        for (int currentRow = 1; currentRow <= nRows; currentRow++) {
            String incoming = scanner.nextLine();

            if (incoming.equals("(") || incoming.equals(")")) { //проверка дали в текущия ред от конзолата има скоби

                if (incoming.equals(currentClamp)) { //проверка дали се следва последователността първо "(" после ")"

                    if (statusClamp == 1) {
                        statusClamp = 2;
                        currentClamp = ")";
                        isOpened = true;
                    } else {
                        statusClamp = 1;
                        currentClamp = "(";
                        isOpened = false;
                    }
                } else {
                    isBalance = false;
                }

            }

        }

        if (isBalance && !isOpened) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }

    }
}
