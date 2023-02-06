package MoreExer_08;

import java.util.Scanner;

public class WinningTicket_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();                              //входни данни
        String[] wordsArr = input.split("(\\s+)*,(\\s+)*");       //масив с думи за проверка

        for (int numWords = 0; numWords < wordsArr.length; numWords++) {
            char[] currentWord = wordsArr[numWords].toCharArray();      //символите на конкретната дума масив

            if (isExistSumChar(currentWord)) {                          //проверка дали думата съдържа 20 символа
                if (isWinSymbol(currentWord)) {                         //проверка дали съдържа печеливш символ
                    int counterLeft = 0;
                    int counterRight = 0;

                    char winSymbol = isCurrentWinSymbol(currentWord);

                    for (int i = 0; i < currentWord.length / 2; i++) {  //проверка колко пъти печелившия символ се повтаря вляво
                        if (currentWord[i] == winSymbol) {
                            counterLeft++;
                        }
                    }
                    for (int i = currentWord.length - 1; i > currentWord.length / 2; i--) { //проверка колко пъти печелившия символ се повтаря вдясно
                        if (currentWord[i] == winSymbol) {
                            counterRight++;
                        }
                    }

                    if (counterLeft == counterRight && counterLeft >= 6 && counterLeft < 10){
                        System.out.printf("ticket \"%s\" - %d%c%n", wordsArr[numWords], counterLeft, winSymbol);
                    }else if(counterLeft == 10){
                        System.out.printf("ticket \"%s\" - %d%c Jackpot!%n", wordsArr[numWords], counterLeft, winSymbol);
                    }else {
                        System.out.printf("ticket \"%s\" - no match", wordsArr[numWords]);
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match", wordsArr[numWords]);
                }
            } else {
                System.out.println("invalid ticket");
            }
        }

    }

    //проверка дали думата съдържа 20 символа
    static boolean isExistSumChar(char[] currentSymbol) {
        return currentSymbol.length == 20;
    }

    //проверка дали съдържа печеливш символ
    static boolean isWinSymbol(char[] currentSymbol) {
        boolean isExist = false;
        for (char e : currentSymbol) {
            if (e == '@' || e == '#' || e == '$' || e == '^') {
                isExist = true;
                break;
            }
        }
        return isExist;
    }

    //проверка кой печеливш символ съдържа думата
    static char isCurrentWinSymbol(char[] currentSymbol) {
        char winSymbol = 0;
        for (char c : currentSymbol) {
            if (c == '@') {
                winSymbol = c;
            } else if (c == '#') {
                winSymbol = c;
            } else if (c == '$') {
                winSymbol = c;
            } else if (c == '^') {
                winSymbol = c;
            }
        }
        return winSymbol;
    }

}
