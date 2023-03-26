import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> emojisList = new ArrayList<>();
        int cool = 1;

        Pattern patternDigit = Pattern.compile("(?<digit>[0-9])");
        Matcher matcherDigit = patternDigit.matcher(input);

        while (matcherDigit.find()) {
            cool *= Integer.parseInt(matcherDigit.group("digit"));
        }

        Pattern pattern = Pattern.compile("([:|*]{2})(?<emoji>[A-Z][a-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);
        int countEmoji = 0;

        while (matcher.find()) {
            String cuurentEmoji = matcher.group("emoji");
            emojisList.add(cuurentEmoji);

            if (charSum(cuurentEmoji) >= cool) {
                countEmoji++;
            }
        }

        System.out.println();
    }

    public static Integer charSum(String emoji) {
        char[] emojiChar = emoji.toCharArray();
        int sumChar = 0;
        for (int i = 0; i < emojiChar.length; i++) {
            sumChar += emojiChar[i];
        }
        return sumChar;
    }
}
