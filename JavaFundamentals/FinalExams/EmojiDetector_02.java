package FinalExams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern digitPattern = Pattern.compile("[0-9]");  //изваждане само на цифрите от текста
        Matcher digitMatcher = digitPattern.matcher(text);

        long threshold = 1;                                     //сбора на извадените цифри от текста
        int counter = 0;                                        //брояч на намерените емоджита

        while (digitMatcher.find()) {
            long currentDigit = Long.parseLong(digitMatcher.group());
            threshold *= currentDigit;                                                        //сбора на всички цифри от текста-threshold
        }

        Pattern pattern = Pattern.compile("(:{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})\\1");  //изваждане на чистото емоджи
        Matcher matcher = pattern.matcher(text);

        List<String> emojiList = new ArrayList<>();     //съдържа емоджитата с cool>threshold

        while (matcher.find()) {
            String match = matcher.group();             //цялата дума
            long cool = 0;                              //сбора от ASCII-стойностите на символите на даденото емоджи
            counter++;

            String emojiClean = matcher.group("emoji");     //само емоджито

            for (int i = 0; i < emojiClean.length(); i++) {       //сборува стойностите на всеки символ от даденото еможи
                char symbol = emojiClean.charAt(i);
                cool += (int) symbol;
            }

            if (cool > threshold) {          //ако сбора на символите на даденото емоджи е по-голямо от threshold влиза в списъка с емоджитата
                emojiList.add(match);
            }
        }

        System.out.printf("Cool threshold: %d%n", threshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", counter);

        for (String s : emojiList) {
            System.out.println(s);
        }
    }
}

