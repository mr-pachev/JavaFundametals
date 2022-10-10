package Exercises._08;

import java.util.Scanner;

public class ValidUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] incomingArray = scanner.nextLine().split(", ");

        for (String items : incomingArray) {

            if (isCorrectUser(items)) {
                System.out.println(items);
            }
        }
    }

    public static boolean isCorrectUser(String user) {
        if (user.length() < 3 || user.length() > 16) {
            return false;
        }

        for (char items : user.toCharArray()) {
            if (!Character.isLetterOrDigit(items) && items != '-' && items != '_') {
                return false;
            }
        }
        return true;
    }
}
