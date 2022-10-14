package MoreExer_03;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] seq = Arrays.stream(scanner.nextLine()
                                .split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();//масив за проверка

        int[] len = new int[seq.length]; //масив, който ще съдържа най-дългата възходяща поредица до текущия елемент включително
                                        //с дължина равна на входящия масив
        int[] les = new int[]{};
        int maxLen = 0;

        //1 2 5 3 5 2 4 1

        for (int indexSeq = 0; indexSeq < seq.length; indexSeq++) { //цикъл обхождащ всички елементи от входящия масив

            len[indexSeq] = 1; //винаги в ляво от първия елемент има само една най-дългата разстяща редица включително и текущия елемент

            for (int indexUnderSeq = 0; indexUnderSeq <= indexSeq - 1; indexUnderSeq++) { //обхождащ входящия масив от начало до елемента преди текущия елемент. Прави се проверка за
                                            //образувала се най-дългата разстяща редица, която може да се продължи с текущия елемент

                if (seq[indexUnderSeq] < seq[indexSeq] && len[indexUnderSeq] + 1 > len[indexSeq]){ //проверка дали текущия елемент е по-голям от първия елемнт, което означава,
                                                            //че текущия елемнт може да продължи нарастващата последователност и в
                                                            //същото време
                   len[indexSeq] = 1 + len[indexUnderSeq];

                    if (len[indexSeq] > maxLen){
                        maxLen = len[indexSeq];
                        les = new int []{seq[indexUnderSeq]};

                    }
                }


            }


        }

        for (int currentValue : les) {
            System.out.printf("%d ", currentValue);
        }

    }
}

