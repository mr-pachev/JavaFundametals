package FinalExams;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String codedWord = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] commands = input.split("\\|");             //масив с командите

            switch (commands[0]) {

                case "Move": {
                    //преместване на елементи от началото вкрая
                    int num = Integer.parseInt(commands[1]);
                    String current = codedWord.substring(0, num);
                    codedWord = codedWord.substring(num);
                    codedWord = codedWord.concat(current);
                    break;
                }
                case "Insert": {
                    //вмъкване на елемент
                    int index = Integer.parseInt(commands[1]);
                    String letter = commands[2];
                    String firstPart = codedWord.substring(0, index);
                    String lastPart = codedWord.substring(index);
                    codedWord = firstPart.concat(letter).concat(lastPart);
                    break;
                }

                case "ChangeAll": {
                    //заместване на символ
                    String oldLetter = commands[1];
                    String newLetter = commands[2];

                    codedWord = codedWord.replaceAll(oldLetter, newLetter);
                    System.out.println();
                    break;
                }
            }
            input = scanner.next();
        }

        System.out.printf("The decrypted message is: %s", codedWord);
    }
}
