package FinalExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PasswordReset_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Done")){
            String command = input.split(" ")[0];
            switch (command){

                case "TakeOdd": {
                    char[] symbols = text.toCharArray();
                    StringBuilder currentWord = new StringBuilder();
                    for (int index = 0; index < symbols.length; index++) {
                        if (index % 2 != 0){
                            currentWord.append(symbols[index]);
                        }
                    }
                    text = currentWord.toString();
                    break;
                }
                case "Cut": {
                    int startIndex = Integer.parseInt(input.split(" ")[1]);
                    int length = Integer.parseInt(input.split(" ")[2]);
                    String firstPart = text.substring(0, startIndex);
                    String secondPart = text.substring(startIndex + length);
                    text = firstPart.concat(secondPart);

                    break;
                }
                case "Substitute": {
                    String oldSymbol = input.split(" ")[1];
                    String newSymbol = input.split(" ")[2];

                    if (text.contains(oldSymbol)){
                        text = text.replaceAll(oldSymbol, newSymbol);
                    }else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
                }
            }
            System.out.println(text);
            input = scanner.nextLine();
        }

        System.out.printf("Your password is: %s", text);
    }
}
