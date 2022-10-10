package Lab._04;

import java.util.Scanner;

public class MathOperations_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputFirstNum = Integer.parseInt(scanner.nextLine());
        String symbol = scanner.nextLine();
        int inputSecondNum = Integer.parseInt(scanner.nextLine());

        double value = getDivision(inputFirstNum, symbol, inputSecondNum);
        System.out.printf("%.0f", value);


    }
    public static double getDivision (int firstNum, String sym, int secondNum){
        double result = 0.0;
       switch (sym){
           case "/":{
               result = firstNum * 1.0 / secondNum;
               break;
           }
           case "*":{
               result = firstNum * secondNum;
               break;
           }
           case "+":{
               result = firstNum + secondNum;
               break;
           }
           case "-":{
               result = firstNum - secondNum;
               break;
           }
       }
       return result;

    }
}
