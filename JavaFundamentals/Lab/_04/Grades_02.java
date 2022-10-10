package Lab._04;

import java.util.Scanner;

public class Grades_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double great = Double.parseDouble(scanner.next());

        notePrint(great);
    }
    public static void notePrint(double note) {
        if (note >= 2.00 && note <= 2.99) {
            System.out.println("Fail");
        } else if (note >= 3.00 && note <= 3.49) {
            System.out.println("Poor");
        } else if (note >= 3.50 && note <= 4.49) {
            System.out.println("Good");
        } else if (note >= 4.50 && note <= 5.49) {
            System.out.println("Very good");
        } else if (note >= 5.50 && note <= 6.00) {
            System.out.println("Excellent");
        }
    }
}
