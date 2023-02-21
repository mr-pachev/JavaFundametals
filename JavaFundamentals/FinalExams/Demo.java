package FinalExams;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String codedWord = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] commands = input.split("\\|");             //масив с командите

            if (commands.length == 2) {                              //преместване на елементи от началото вкрая
                int num = Integer.parseInt(commands[1]);
                    String current = codedWord.substring(0, num);
                  codedWord = codedWord.substring(num);
                  codedWord = codedWord.concat(current);

            } else if (commands.length == 3) {

                if (isNumeric(commands[1])) {                           //вмъкване на елемент
                    int index = Integer.parseInt(commands[1]);
                    String current = commands[2];
                    String firstPart = codedWord.substring(0, index);
                    String lastPart = codedWord.substring(index);
                    codedWord = firstPart.concat(current).concat(lastPart);
                    System.out.println();

                } else {                                                 //заместване на символ
                    String oldLetter = commands[1];
                    String newLetter = commands[2];

                   codedWord = codedWord.replaceAll(oldLetter, newLetter);
                    System.out.println();
                }
            }
            input = scanner.next();
        }

        System.out.printf("The decrypted message is: %s", codedWord);
    }
    //метод за проверка дали String-a е число
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
