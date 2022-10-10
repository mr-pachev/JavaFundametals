package FinalExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("(@|#)(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(input);

        List<String> wordPairsList = new ArrayList<>(); //лист за съхраняване на огледалните двойки думи
        int counter = 0;

        while (matcher.find()) {
            String firstWord = matcher.group("first");
            String secondWord = matcher.group("second");
            StringBuilder builder = new StringBuilder(secondWord); //стрингбилдера има функция reverse
            String reversWord = builder.reverse().toString(); //резултата се преобразува в стринг
            counter++;

            if (firstWord.equals(reversWord)) {
                wordPairsList.add(firstWord + " <=> " + secondWord);
            }

        }
        if (counter == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", counter);
        }

        if (wordPairsList.size() == 0) {
            System.out.println("No mirror words!");
        }else {
            System.out.println("The mirror words are: ");
            System.out.println(String.join(", ", wordPairsList));
        }
    }
}
