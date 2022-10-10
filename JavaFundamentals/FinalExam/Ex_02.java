package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        boolean isValid = false;

        for (int i = 1; i <= n; i++) {
            String incomin = scanner.nextLine();
            isValid = false;
            Pattern patternTag = Pattern.compile("([$\\|%])(?<word>[A-Z][a-z]{3,})\\1");
            Matcher matcherTag = patternTag.matcher(incomin);
            StringBuilder finalWord = new StringBuilder();

            while (matcherTag.find()) {
                String tag = matcherTag.group("word");
                isValid = true;

                String codeWord = incomin.split(": ")[1];
                String[] codeWordLength = codeWord.split("\\|");

                if (codeWordLength.length > 3) {
                    isValid = false;
                    break;
                } else {

                    Pattern patternSymbol = Pattern.compile("[^\\[]\\d+");
                    Matcher matcherSymbol = patternSymbol.matcher(codeWord);

                    while (matcherSymbol.find()) {
                        int currentSymbol = Integer.parseInt(matcherSymbol.group());
                        char letter = (char) currentSymbol;
                        finalWord.append(letter);
                    }
                    System.out.println(tag + ": " + finalWord.toString());
                }
                if (!isValid) {
                    break;
                }
            }
            if (isValid) {
                System.out.println("Valid message not found!");
            }
        }

    }
}
