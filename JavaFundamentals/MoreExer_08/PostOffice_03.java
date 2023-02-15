package MoreExer_08;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PostOffice_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|"); //входни данни

        Pattern lettersPattern = Pattern.compile("([#\\$%\\*&])(?<letters>[A-Z]+)(?:\\1)"); //regex за главните букви


        System.out.println();
    }
}
