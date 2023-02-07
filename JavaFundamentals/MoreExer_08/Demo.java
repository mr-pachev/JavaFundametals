package MoreExer_08;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();                                //входни данни
        String[] wordsArr = input.split("(\\s+)*,(\\s+)*");         //масив с думи за проверка

        for (int numWords = 0; numWords < wordsArr.length; numWords++) {
            char[] currentWord = wordsArr[numWords].toCharArray();        //конкретната дума
            boolean isMatch = false;

            Pattern pattern = Pattern.compile("(\\@{6,10}|\\${6,10}|\\^{6,10}|\\#{6,10})");

            StringBuilder leftPart = new StringBuilder();                //за лявата част на думата
            StringBuilder rightPart = new StringBuilder();               //за дясната част на думата

            for (int i = 0; i < currentWord.length / 2; i++) {           //взимане на лявата част на думата
                leftPart.append(currentWord[i]);
            }

            Matcher matcherLeft = pattern.matcher(leftPart);                 //проверка за съвпадение на лявата част на думата

            while (matcherLeft.find()){
                String leftTail = matcherLeft.group();                       //съвпадение отговарящо на regex-са
                isMatch = true;
            }

            if (!isMatch){
                continue;
            }

            for (int i = currentWord.length - 1; i >= currentWord.length / 2; i--) {    //взимане на дясната част на думата
                rightPart.append(currentWord[i]);
            }

            Matcher matcherRight = pattern.matcher(leftPart);                           //проверка за съвпадение на дясната част на думата

            while  (matcherRight.find()){
                String rightTail = matcherRight.group();                                //съвпадение отговарящо на regex-са
                System.out.println();
            }
        }
    }
}
