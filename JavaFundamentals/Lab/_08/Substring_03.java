package Lab._08;

import java.util.Scanner;

public class Substring_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String textOne = scanner.nextLine();
        String textTwo = scanner.nextLine();

        while (textTwo.contains(textOne)) {

            textTwo = textTwo.replace(textOne, "");
        }
        System.out.println(textTwo);
    }
}