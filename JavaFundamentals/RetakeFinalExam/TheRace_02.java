package RetakeFinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheRace_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        boolean isTrue = false;

        while (input != null) {

            Pattern pattern = Pattern.compile("([#$%*&])(?<name>[\\w]+)\\1[\\=](?<length>[0-9]+)[\\!]{2}(?<geohashcode>[\\w]+)");
            Matcher matcher = pattern.matcher(input);

            String message = "";
            String decrypted = "";

            while (matcher.find()) {
                int length = Integer.parseInt(matcher.group("length"));
                message = matcher.group("geohashcode");
                String name = matcher.group("name");

                int index = input.indexOf("!!") + 2;
                String geoHashCode = input.substring(index);

                if (geoHashCode.length() == length){
                    decrypted = decrypted(geoHashCode, length);
                    System.out.printf("Coordinates found! %s -> %s%n", name, decrypted);
                    isTrue = true;
                }
            }

            if (!isTrue) {
                System.out.println("Nothing found!");
                input = scanner.nextLine();
            }else {
                break;
            }
        }
    }

    public static String decrypted(String message, int length) {
        String decryptedMess = "";
        char[] symbolArr = message.toCharArray();

        for (int i = 0; i < symbolArr.length; i++) {
            char letter = (char) (symbolArr[i] + length);
            decryptedMess += letter;
        }
        return decryptedMess;
    }
}
