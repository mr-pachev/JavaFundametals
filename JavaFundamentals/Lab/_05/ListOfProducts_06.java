package Lab._05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListOfProducts_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> products = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String incomingProducts = scanner.nextLine();

            products.add(incomingProducts);
        }
        Collections.sort(products);

        for (int i = 0; i < n ; i++) {
            System.out.printf("%d.%s%n", i + 1, products.get(i));
        }
    }
}
