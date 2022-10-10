package Exercises._04;

import java.util.Scanner;

public class TopNumber_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) { // обхождаме диапазона от 1 до n

            if (isDivisionOn8(i) && isDigitOdd(i)) { // проверка дали текущото число i от диапазона 1 до n e TOPnumber
                System.out.println(i);
            }

        }
    }

    private static boolean isDivisionOn8(int num) { // метод за проверка сбора на цифрите на число дали се дели на 8
        int sumDigit = 0;
        int lastDigit = 0;
        while (num > 0) { // разбиване число на цифри
            lastDigit = num % 10;
            sumDigit += lastDigit;
            num = num / 10;
        }
        return (sumDigit % 8 == 0); // проверка сбора от цифрите на число дали се дели на 8 -> връща false или true
    }

    private static boolean isDigitOdd(int num) { // метод за проверка дали някоя от цифрите на числото е нечетно
        int lastDigit = 0;
        while (num > 0) { // разбиване числото на цифри
            lastDigit = num % 10;
            if (lastDigit % 2 != 0) { // проверка всяка цифра от числото дали е нечетна
                return true; // връща true и прекъсва метода
            }
            num /= 10;
        }
        return false; // при всички други случаи изключващи if проверката се връща false
    }
}