package Lab._04;

import java.util.Scanner;

public class RepeatString_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        String value = repeatsInput(input, n); // изнасяма резултата (стринга) от метода в променлива
        System.out.print(value);
    }

    public static String repeatsInput(String incoming, int count) {
        String result = "";
        for (int i = 1; i <= count; i++) {
            result = result + incoming;
        }
        return result;
    }
}
