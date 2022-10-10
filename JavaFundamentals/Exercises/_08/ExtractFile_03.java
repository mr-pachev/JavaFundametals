package Exercises._08;

import java.util.Scanner;

public class ExtractFile_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] incoming = scanner.nextLine().split("\\\\");

        String filePatch = incoming[incoming.length - 1];
        String fileName = filePatch.split("\\.")[0];
        String extension = filePatch.split("\\.")[1];

        System.out.printf("File name: %s%n ", fileName);
        System.out.printf("File extension: %s%n ", extension);
    }
}
