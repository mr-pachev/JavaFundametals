import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> emojisList = new ArrayList<>();
        List<String> coolEmojiList = new ArrayList<>();
        int cool = 1;

        Pattern patternDigit = Pattern.compile("(?<digit>[0-9])");
        Matcher matcherDigit = patternDigit.matcher(input);

        while (matcherDigit.find()) {
            cool *= Integer.parseInt(matcherDigit.group("digit"));
        }

        Pattern pattern = Pattern.compile("(:{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String currentEmoji = matcher.group("emoji");
            String currentMatch = matcher.group();
            emojisList.add(currentEmoji);

            if (charSum(currentEmoji) >= cool) {
                coolEmojiList.add(currentMatch);
            }
        }

        System.out.printf("Cool threshold: %d%n", cool);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojisList.size());
        for (String s : coolEmojiList) {
            System.out.println(s);
        }
    }

    //метод за сумиране на символите от даден String
    public static Integer charSum(String emoji) {
        char[] emojiChar = emoji.toCharArray();
        int sumChar = 0;
        for (int i = 0; i < emojiChar.length; i++) {
            sumChar += emojiChar[i];
        }
        return sumChar;
    }
}
