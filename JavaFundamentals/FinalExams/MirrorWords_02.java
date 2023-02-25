package FinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        List<String> wordList = new ArrayList<>();
        int counterFinds = 0;

        Pattern pattern = Pattern.compile("([#|@])(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            counterFinds++;
            String firstWord = matcher.group("first");
            String secondWord = matcher.group("second");

            if (isCorrect(firstWord, secondWord)){
                wordList.add(firstWord);
                wordList.add(secondWord);
            }
        }

        if (counterFinds > 0){
            System.out.printf("%d word pairs found!%n", counterFinds);

            if (wordList.isEmpty()){
                System.out.println("No mirror words!");
            }else {
                System.out.println("The mirror words are:");
                int counter = 0;

                for (int i = 0; i < wordList.size(); i++) {
                    if (i == wordList.size() - 1){
                        System.out.println(wordList.get(i));
                    }else if (counter == 0){
                        counter++;
                        System.out.printf("%s <=> ", wordList.get(i));
                    }else if (counter == 1){
                        counter = 0;
                        System.out.printf("%s,", wordList.get(i));
                    }
                }
            }

        }else {
            System.out.println("No word pairs found!");
        }

    }

    //метод за сравняване на два String-a дали са огледални
    public static boolean isCorrect(String first, String second) {
        char[] firstWord = first.toCharArray();
        char[] secondWord = second.toCharArray();
        boolean isCorrect = false;

        if (firstWord.length == secondWord.length) {
            for (int i = 0; i < firstWord.length; i++) {
                if (firstWord[i] != secondWord[firstWord.length - 1 - i]){
                    isCorrect = false;
                    break;
                }else {
                    isCorrect = true;
                }
            }
        }
        return isCorrect;
    }
}
