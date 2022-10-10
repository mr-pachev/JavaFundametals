package Lab._05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int numSize = numbersList.size();

        for (int i = 0; i < numSize / 2; i++) {
            int firstEl = numbersList.get(i);
            int lastEl = numbersList.get(numbersList.size() - 1);

            numbersList.set(i, firstEl + lastEl);
            numbersList.remove(numbersList.size() - 1);
        }
        for (int num : numbersList){
            System.out.print(num + " ");
        }
    }
}
