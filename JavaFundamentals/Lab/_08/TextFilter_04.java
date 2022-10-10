package Lab._08;

import java.util.List;
import java.util.Scanner;

public class TextFilter_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWordsArray = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

       for (String items : bannedWordsArray){
           if(text.contains(items)) {

               text = text.replace(items, getSymbolSum(items, items.length()-1));
           }
        }
        System.out.println(text);
    }
    public static String getSymbolSum(String bannedWord, int counter){
        String sumSymbol = "";
        for (int i = 0; i < bannedWord.length(); i++) {
            sumSymbol += "*";
        }
        return sumSymbol;
    }
}
