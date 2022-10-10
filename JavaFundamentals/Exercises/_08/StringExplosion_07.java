package Exercises._08;

import java.util.Scanner;

public class StringExplosion_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder text = new StringBuilder(input);
        int power = 0;

        for (int i = 0; i < text.length(); i++) {

            char current = text.charAt(i);
            if (current == '>') {
                power += Integer.parseInt(text.charAt(i+1) + "");
            } else if (current != '>' && power > 0) {
                text.deleteCharAt(i);
                i--;
                power--;
            }
        }
        System.out.println(text);
    }
}

