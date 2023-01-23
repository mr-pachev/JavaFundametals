package MoreExer_07;

import jdk.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HTML_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String articleName = scanner.nextLine();
        String articleContains = scanner.nextLine();
        String input = scanner.nextLine();;

        List<String> comment = new ArrayList<>();

        while (!input.equals("end of comments")) {
            comment.add(input);

            input =scanner.nextLine();
        }

        System.out.printf("<h1>%n    %s%n</h1>%n", articleName);
        System.out.printf("<article>%n    %s%n</article>%n", articleContains);

        for (int i = 0; i < comment.size(); i++) {
            System.out.printf("<div>%n    %s%n</div>%n", comment.get(i));
        }
    }
}
