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

            if (currentWord.length != 20) {
                System.out.println("invalid ticket");
                continue;
            }

            Pattern pattern = Pattern.compile("(\\@{6,10}|\\${6,10}|\\^{6,10}|\\#{6,10})");

            StringBuilder leftPart = new StringBuilder();                //за лявата част на думата
            StringBuilder rightPart = new StringBuilder();               //за дясната част на думата
            char symbolLeft = '0';
            char symbolRight = '0';
            String leftTail = "";
            String rightTail = "";

            for (int i = 0; i < 10; i++) {                                //взимане на лявата част на думата
                leftPart.append(currentWord[i]);
            }

            Matcher matcherLeft = pattern.matcher(leftPart);              //проверка за съвпадение на лявата част на думата

            while (matcherLeft.find()) {
                leftTail = matcherLeft.group();                           //съвпадение отговарящо на regex-са
                symbolLeft = leftTail.charAt(0);
                isMatch = true;
            }

            for (int i = 10; i < 20; i++) {                               //взимане на дясната част на думата
                rightPart.append(currentWord[i]);
            }

            Matcher matcherRight = pattern.matcher(rightPart);             //проверка за съвпадение на дясната част на думата

            while (matcherRight.find()) {
                rightTail = matcherRight.group();                         //съвпадение отговарящо на regex-са
                symbolRight = rightTail.charAt(0);
            }

            if ((symbolLeft == symbolRight) && isMatch) {                  //проверка дали символите в двете части на думата са еднакви

                if (leftTail.length() < rightTail.length()) {
                    System.out.printf("ticket \"%s\" - %d%s%n", wordsArr[numWords], leftTail.length(), symbolLeft);
                }
                if (leftTail.length() > rightTail.length()) {
                    System.out.printf("ticket \"%s\" - %d%s%n", wordsArr[numWords], rightTail.length(), symbolRight);
                }
                if (leftTail.length() == rightTail.length() && leftTail.length() == 10) {
                    System.out.printf("ticket \"%s\" - %d%s Jackpot!%n", wordsArr[numWords], rightTail.length(), symbolLeft);
                }else if (leftTail.length() == rightTail.length()){
                    System.out.printf("ticket \"%s\" - %d%s%n", wordsArr[numWords], rightTail.length(), symbolRight);
                }

            } else {
                System.out.printf("ticket \"%s\" - no match", wordsArr[numWords]);
            }
        }
    }
}
