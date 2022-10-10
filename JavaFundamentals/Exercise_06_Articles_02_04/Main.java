package Exercise_06_Articles_02_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String title = ""; // заглавие
        String content = ""; // съдържание
        String author = ""; // автор

        Articles articles = new Articles(title, content, author); // създаване на обект с полетата от класа Articles

        List<Articles> articlesList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String inputArticle = scanner.nextLine(); // въвеждаме статията

            title = inputArticle.split(", ")[0]; // заглавие
            content = inputArticle.split(", ")[1]; // съдържание
            author = inputArticle.split(", ")[2]; // автор
            articles = new Articles(title, content, author); // създаване на обект с полетата от класа Articles

            articlesList.add(articles);
        }
        String command = scanner.nextLine();
        for (Articles items : articlesList) {
            System.out.println(items.toString());
        }
    }
}
