package MoreExer_02;

import java.util.Scanner;

public class DecryptingMessage_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine()); //ключ
        int numCharters = Integer.parseInt(scanner.nextLine()); //брой на буквите, които ще се въвеждат

        for (int currentChar = 1; currentChar <= numCharters; currentChar++) { //цикъл онтговорящ на буквите, които ще се въвеждат
            String charIncoming = scanner.nextLine();
            char letter = charIncoming.charAt(0);

            letter += key;
            System.out.print(letter);
        }

    }
}
