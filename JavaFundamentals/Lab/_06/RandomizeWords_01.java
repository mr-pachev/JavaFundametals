package Lab._06;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomizeWords_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> wordsList = Arrays.stream(scanner.nextLine().split(" ")) // входящ масив от думи от конзолота
                .collect(Collectors.toList());

        while (!wordsList.isEmpty()) {
            Random rnd = new Random(); // обект от клас Random
            int currentWords = rnd.nextInt(wordsList.size()); // цяло число от пройзволен индекс на масива с граница дължината на масива

            System.out.println(wordsList.get(currentWords)); // принтеране на думата с текущия индекс от масива
            wordsList.remove(currentWords); // премахване на думата от масива с цел да не се повтори при принтиране
        }
    }
}
