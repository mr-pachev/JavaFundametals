package MoreExer_08;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static jdk.internal.joptsimple.internal.Strings.repeat;

public class RageQuit_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern patter = Pattern.compile("(?<symbol>[\\D]+)(?<count>[\\d]+)");
        Matcher matcher = patter.matcher(input);

        StringBuilder repeatWord = new StringBuilder();
        StringBuilder noRepeatWord = new StringBuilder();


        while (matcher.find()) {
            String currentSymbol = matcher.group("symbol");
            int counter = Integer.parseInt(matcher.group("count"));
            repeatWord.append(repeat(currentSymbol, counter));
            noRepeatWord.append(currentSymbol.toUpperCase());
        }

        noRepeatWord = new StringBuilder(removeDuplicateChar(noRepeatWord.toString()));

        System.out.printf("Unique symbols used: %d%n", noRepeatWord.length());
        System.out.println(String.join("", repeatWord));
    }

    public static String removeDuplicateChar(String str){
        char charArray[] = str.toCharArray();
        StringBuilder stringBuilder= new StringBuilder();
        for(int i=0; i<charArray.length; i++){
            int index = stringBuilder.toString().indexOf(charArray[i]);
            if(index <= -1){
                stringBuilder.append(charArray[i]);
            }
        }
        return stringBuilder.toString();
    }

    //повтаряне на дадената дума според зададения брояч
    static String repeat(String s, int repeatCount) {
        String[] repeatArr = new String[repeatCount];
        for (int i = 0; i < repeatCount; i++) {
            repeatArr[i] = s.toUpperCase();
        }
        return String.join("", repeatArr);
    }

}
