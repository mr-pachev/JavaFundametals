package FinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern digitPattern = Pattern.compile("[0-9]");
        Matcher digitMatcher = digitPattern.matcher(text);
        int threshold = 1;

        while (digitMatcher.find()) {
            int currentDigit = Integer.parseInt(digitMatcher.group());
            threshold *= currentDigit;
        }

        Pattern pattern = Pattern.compile("([\\::|\\**]{2})(?<emoji>[A-Z][a-z]{2,})\\1");
        Matcher matcher = pattern.matcher(text);

        List<String> emojiList = new ArrayList<>();
        List<String> onlyEmojiList = new ArrayList<>();

        while (matcher.find()) {
            String match = matcher.group();
            String emojiClean = matcher.group("emoji");
            onlyEmojiList.add(emojiClean);
            emojiList.add(match);
        }

        for (int i = 0; i < onlyEmojiList.size(); i++) {
            char[] word = onlyEmojiList.get(i).toCharArray();

            if (charCount(word) < threshold) {
                emojiList.remove(i);
            }
        }

        System.out.printf("Cool threshold: %d%n", threshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", onlyEmojiList.size());

        for (String s : emojiList){
            System.out.println(s);
        }
    }

    public static Integer charCount(char[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
        }
        return count;
    }
}

