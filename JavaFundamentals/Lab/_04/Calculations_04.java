package Lab._04;

import java.util.Scanner;

public class Calculations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case "add": {
                addCommand(firstNum, secondNum);
                break;
            }
            case "multiply": {
                multiplyCommand(firstNum, secondNum);
                break;
            }
            case "subtract": {
                subtractCommand(firstNum, secondNum);
                break;
            }
            case "divide": {
                divideCommand(firstNum, secondNum);
                break;
            }
        }
    }


    public static void addCommand(int a, int b) {
        int result = a + b;
        System.out.println(result);
    }

    public static void multiplyCommand(int a, int b) {
        int result = a * b;
        System.out.println(result);
    }

    public static void subtractCommand(int a, int b) {
        int result = a - b;
        System.out.println(result);
    }

    public static void divideCommand(int a, int b) {
        int result = a / b;
        System.out.println(result);
    }
}
