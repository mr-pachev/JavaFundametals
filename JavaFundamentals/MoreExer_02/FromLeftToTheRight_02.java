package MoreExer_02;

import java.util.Scanner;

public class FromLeftToTheRight_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sumLeftNum = 0;
        int sumRightNum = 0;

        for (int i = 1; i <= n; i++) { //определя колко реда ще получим от входа
            String inputNumbers = scanner.nextLine(); //низ с двете числа

            String leftNumber = inputNumbers.split(" ")[0];
            String rightNumber = inputNumbers.split(" ")[1];

            double leftNum = Double.parseDouble(leftNumber); //ляво число
            double rightNum = Double.parseDouble(rightNumber);; //дясно число

            if (leftNum > rightNum){
                sumLeftNum = sumDigit(leftNumber);
                System.out.println(sumLeftNum);
            }else {
                sumRightNum = sumDigit(rightNumber);
                System.out.println(sumRightNum);
            }
        }

    }
    //метод за сумира не всяка цифра от конкретно число
    public static Integer sumDigit (String num){
        int sumDigits = 0;
        double digit = Math.abs(Double.parseDouble(num)); //числото трябва да е положително заради делението
        for (int currentDigit = 1; currentDigit <= num.length(); currentDigit++) {
            sumDigits += digit % 10;
            digit /= 10;
        }
        return sumDigits;
    }
}
