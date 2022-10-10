package Lab._07;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.stream;

public class WordFilter_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String[] words = Arrays.stream(scanner.nextLine().split(" "))
               .filter(e -> e.length() % 2 == 0)
               .toArray(String[]::new);

        System.out.println(String.join(System.lineSeparator(), words));
    }
}
