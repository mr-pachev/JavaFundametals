package Exercises._08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CharacterMultiplier_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String incoming = scanner.nextLine();
        String first = incoming.split(" ")[0];
        String second = incoming.split(" ")[1];

        long sum = allSum(first, second);

        System.out.println(sum);
    }

    public static long allSum(String one, String two) {
        long sum = 0;

        char[] firstCh = one.toCharArray();
        char[] secondCh = two.toCharArray();

        int minString = Math.min(one.length(), two.length());
        int maxString = Math.max(one.length(), two.length());

        if (firstCh.length == minString){ //проверка дали първия низ е по-къс
            for (int i = 0; i < firstCh.length; i++) {
                sum += firstCh[i] * secondCh[i];
            }
            for (int i = firstCh.length; i < secondCh.length ; i++) {
                sum += secondCh[i];
            }

        }else { //втория низ е по-къс
            for (int i = 0; i < secondCh.length; i++) {
                sum += firstCh[i] * secondCh[i];
            }
            for (int i = secondCh.length; i < firstCh.length; i++) {
                sum += firstCh[i];
            }

            if (firstCh == secondCh){
                for (int i = 0; i < secondCh.length; i++) {
                    sum += firstCh[i] * secondCh[i];
                }
            }
        }
        return sum;
    }
}