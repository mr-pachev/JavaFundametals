package FinalExams;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SecretChat_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String codedText = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.contains("Reveal")) {
            String command = input.split("\\:\\|\\:")[0];

            switch (command) {
                case "InsertSpace": {
                    int index = Integer.parseInt(input.split("\\:\\|\\:")[1]);
                    String firstPart = codedText.substring(0, index);
                    String secondPart = codedText.substring(index);
                    codedText = firstPart.concat(" ").concat(secondPart);
                    System.out.println(codedText);
                    break;
                }
                case "Reverse": {
                    String foReverse = input.split("\\:\\|\\:")[1];
                    if (codedText.contains(foReverse)){
                       String reverse = isReverse(foReverse);
                        codedText = codedText.replace(foReverse, reverse);
                    }else {
                        System.out.println("error");
                    }
                    break;
                }
                case "ChangeAll": {
                    String oldWord = input.split("\\:\\|\\:")[1];
                    String newWord = input.split("\\:\\|\\:")[2];

                    codedText = codedText.replaceAll(oldWord, newWord);
                    System.out.println(codedText);
                    break;
                }
            }

            input = scanner.nextLine();
        }

        System.out.printf("You have a new text message: %s", codedText);
    }

    //метод за преобръщане на String-a
    public static String isReverse(String word){
        char[] symbolArr = word.toCharArray();
        StringBuilder reverse = new StringBuilder();

        for (int i = symbolArr.length - 1; i >= 0; i--) {
            reverse.append(symbolArr[i]);
        }
        return reverse.toString();
    }
}
