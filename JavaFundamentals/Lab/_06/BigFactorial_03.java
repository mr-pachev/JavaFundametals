package Lab._06;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        BigInteger bigNum = new BigInteger(String.valueOf(1)); // присвояване на цяло число на обекта от клас BigInteger с помоща на String.valueOf - защото очаква референтна стойност
        for (int i = 1; i <= n; i++) {

            bigNum = bigNum.multiply(BigInteger.valueOf(i));// метод от класа BigInteger, който умножава цяло число с помоща на String.valueOf - защото очаква референтна стойност
        }
        System.out.println(bigNum);
    }
}
