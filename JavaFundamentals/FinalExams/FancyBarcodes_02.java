package FinalExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int input = 0; input < n; input++) {
            String text = scanner.nextLine();
            boolean isMatch = false;

            Pattern pattern = Pattern.compile("[@][#]+(?<word>[A-Z][a-zA-Z0-9]{4,}[A-Z])[@][#]+");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()){
                isMatch = true;
                char[] textArr = matcher.group("word").toCharArray();
                String productGroup = isDigit(textArr);

                if(productGroup.isEmpty()){
                    System.out.println("Product group: 00");
                }else {
                    System.out.printf("Product group: %s%n", productGroup);
                }

             }

            if(!isMatch){
                System.out.println("Invalid barcode");
            }
        }
    }

    public static String isDigit(char[] arr){
        StringBuilder digit = new StringBuilder();
        for (int index = 0; index < arr.length ; index++) {
            if (Character.isDigit(arr[index])){
                digit.append(arr[index]);
            }
        }
        return digit.toString();
    }
}
