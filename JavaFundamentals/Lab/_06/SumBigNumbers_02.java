package Lab._06;

import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger firstNum = new BigInteger(scanner.nextLine()); //обект от клас BigInteger - вход от конзолата на голямо число
        BigInteger secondNum = new BigInteger(scanner.nextLine()); //обект от клас BigInteger - вход от конзолата на голямо число

        BigInteger sumNum = firstNum.add(secondNum); // метод от клас BigInteger за прибавяне на едно число към дадено число

        System.out.println(sumNum);
    }
}
