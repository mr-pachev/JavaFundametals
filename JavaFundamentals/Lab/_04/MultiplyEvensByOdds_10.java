package Lab._04;

import java.util.Scanner;

public class MultiplyEvensByOdds_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String num = String.valueOf(n);
        int length = num.length();

        System.out.println(Math.abs(getMultipleOfEvensAndOdds(n)));
    }

    public static int getMultipleOfEvensAndOdds(int num) {
        int eventSum = getAggregateEvent(num);
        int oddSum = getAggregateOdd(num);
        int result = eventSum * oddSum;
        return result;
    }

    public static int getAggregateEvent(int inputNum) {
        String num = String.valueOf(inputNum);
        int length = num.length();
        int event = 0;
        int sumEvent = 0;
        int cuurent = inputNum;

        for (int i = 1; i <= length; i++) {
            event = cuurent % 10;
            if (event % 2 == 0) {
                sumEvent += event;
            }
            cuurent = cuurent / 10;
        }
        return sumEvent;
    }

    public static int getAggregateOdd(int inputNum) {
        String num = String.valueOf(inputNum);
        int length = num.length();
        int odd = 0;
        int sumOdd = 0;
        int current = inputNum;

        for (int i = 1; i <= length; i++) {
            odd = current % 10;
            if (odd % 2 != 0) {
                sumOdd += odd;
            }
            current = current / 10;
        }
        return sumOdd;
    }
}
