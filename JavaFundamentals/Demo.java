import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String codedText = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Decode")){
            String command = input.split("\\|")[0];

            switch (command){

                case "Move":
                    int sumLetters = Integer.parseInt(input.split("\\|")[1]);

                    String moveText = codedText.substring(0, sumLetters);
                    String endTextMove = codedText.substring(sumLetters);
                    codedText = "";
                    codedText = codedText.concat(endTextMove).concat(moveText);
                    break;

                case "Insert":
                    int indexInsert = Integer.parseInt(input.split("\\|")[1]);
                    String newLetter = input.split("\\|")[2];

                    String startTextInsert = codedText.substring(0, indexInsert);
                    String endTextInsert = codedText.substring(indexInsert);

                    codedText = "";
                    codedText = codedText.concat(startTextInsert).concat(newLetter).concat(endTextInsert);
                    break;

                case "ChangeAll":
                    String oldLetters = input.split("\\|")[1];
                    String newLetters = input.split("\\|")[2];

                    codedText = codedText.replace(oldLetters, newLetters);
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s", codedText);
    }
}
