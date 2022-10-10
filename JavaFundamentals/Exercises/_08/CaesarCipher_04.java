package Exercises._08;

import java.util.Scanner;

public class CaesarCipher_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String incoming = scanner.nextLine();
        StringBuilder encryptedText = new StringBuilder();

        for (char items : incoming.toCharArray()) {
            int position = (int) items + 3;
            char current = (char) position;
            encryptedText.append(current);
        }
        System.out.println(encryptedText);
    }
}
