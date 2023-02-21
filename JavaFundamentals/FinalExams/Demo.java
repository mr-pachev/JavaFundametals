package FinalExams;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String codedWord = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] data = input.split("\\|");
            String commands = data[0];

            switch (commands) {

                case "Move": {
                    int num = Integer.parseInt(data[1]);
                    String firstPart = codedWord.substring(0, num);
                    String lastPart = codedWord.substring(num);
                    codedWord = lastPart.concat(firstPart);
                    break;
                }
                case "Insert": {
                    int index = Integer.parseInt(data[1]);
                    String letter = data[2];

                    String firstPart = codedWord.substring(0, index);
                    String lastPart = codedWord.substring(index);
                    codedWord = firstPart.concat(letter).concat(lastPart);
                    break;
                }
                case "ChangeAll": {
                    String oldLetter = data[1];
                    String newLetter = data[2];

                    codedWord = codedWord.replace(oldLetter, newLetter);
                    break;
                }
            }
            input = scanner.next();
        }

        System.out.printf("The decrypted message is: %s%n", codedWord);
    }
}
