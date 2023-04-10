package RetakeFinalExam;

import java.util.Scanner;

public class Easter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Easter")) {
            String command = input.split(" ")[0];

            switch (command) {
                case "Replace":
                    String currentSymbol = input.split(" ")[1];
                    String newSymbol = input.split(" ")[2];
                    text = text.replaceAll(currentSymbol, newSymbol);
                    System.out.println(text);
                    break;

                case "Remove":
                    String substringRemove = input.split(" ")[1];
                    int startInd = text.indexOf(substringRemove);
                    int endInd = startInd + substringRemove.length();

                    if (startInd >= 0 && endInd <= text.length() - 1) {
                        String firstPart = text.substring(0, startInd);
                        String secondPart = text.substring(endInd);
                        text = "";
                        text = text.concat(firstPart).concat(secondPart);
                    }
                    System.out.println(text);
                    break;

                case "Includes":
                    String includesText = input.split(" ")[1];
                    if (text.contains(includesText)) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                    break;

                case "Change":
                    String letterType = input.split(" ")[1];
                    if (letterType.equals("Lower")) {
                        text = text.toLowerCase();
                    } else if (letterType.equals("Upper")) {
                        text = text.toUpperCase();
                    }
                    System.out.println(text);
                    break;

                case "Reverse":
                    int startIndex = Integer.parseInt(input.split(" ")[1]);
                    int endIndex = Integer.parseInt(input.split(" ")[2]);

                    if (startIndex >= 0 && endIndex <= text.length() - 1) {
                        String reverseText = text.substring(startIndex, endIndex + 1);
                        System.out.println(isReverse(reverseText));
                    }
                    break;
            }

            input = scanner.nextLine();
        }


    }
    //метод за преобръщане на String-a
    public static String isReverse(String word){
        char[] symbolArr = word.toCharArray();
        StringBuilder reverse = new StringBuilder();

        for (int i = symbolArr.length - 1; i >= 0; i--) {
            reverse.append(symbolArr[i]);
        }
        return reverse.toString();
    }
}
