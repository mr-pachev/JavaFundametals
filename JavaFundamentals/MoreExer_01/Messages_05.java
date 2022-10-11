package MoreExer_01;

import java.util.Scanner;

public class Messages_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine()); //броя на числата, които ще се въвеждат

        for (int i = 1; i <= num; i++) {
            String number = scanner.nextLine(); //текущо число
            int currenNumber = Integer.parseInt(number);
            currenNumber = currenNumber % 10; //отделяне на първата цифра от текущото число за проверка

            //проверка коя буква да се изпише според клавиатурата и броя на цифрите –от 1 до 3 цифри)
            if (currenNumber == 0) {
                System.out.print(" ");

            } else if (currenNumber == 2) { //проверка коя цифра е натисната
                if (number.length() == 1) { //проверка колко пъти е натисната цифрата
                    System.out.print("a");
                } else if (number.length() == 2) {
                    System.out.print("b");
                } else if (number.length() == 3) {
                    System.out.print("c");
                }

            } else if (currenNumber == 3) {
                if (number.length() == 1) {
                    System.out.print("d");
                } else if (number.length() == 2) {
                    System.out.print("e");
                } else if (number.length() == 3) {
                    System.out.print("f");
                }

            } else if (currenNumber == 4) {
                if (number.length() == 1) {
                    System.out.print("g");
                } else if (number.length() == 2) {
                    System.out.print("h");
                } else if (number.length() == 3) {
                    System.out.print("i");
                }

            } else if (currenNumber == 5) {
                if (number.length() == 1) {
                    System.out.print("j");
                } else if (number.length() == 2) {
                    System.out.print("k");
                } else if (number.length() == 3) {
                    System.out.print("l");
                }

            } else if (currenNumber == 6) {
                if (number.length() == 1) {
                    System.out.print("m");
                } else if (number.length() == 2) {
                    System.out.print("n");
                } else if (number.length() == 3) {
                    System.out.print("o");
                }

            } else if (currenNumber == 7) {
                if (number.length() == 1) {
                    System.out.print("p");
                } else if (number.length() == 2) {
                    System.out.print("q");
                } else if (number.length() == 3) {
                    System.out.print("r");
                } else if (number.length() == 4) {
                    System.out.print("s");
                }

            } else if (currenNumber == 8) {
                if (number.length() == 1) {
                    System.out.print("t");
                } else if (number.length() == 2) {
                    System.out.print("u");
                } else if (number.length() == 3) {
                    System.out.print("v");
                }

            } else if (currenNumber == 9) {
                if (number.length() == 1) {
                    System.out.print("w");
                } else if (number.length() == 2) {
                    System.out.print("x");
                } else if (number.length() == 3) {
                    System.out.print("y");
                } else if (number.length() == 4) {
                    System.out.print("z");
                }
            }
        }

    }
}
