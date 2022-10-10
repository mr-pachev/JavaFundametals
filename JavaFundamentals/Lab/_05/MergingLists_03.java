package Lab._05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();

        int minList = Math.min(firstList.size(), secondsList.size()); // взима се min дължина от между двата списъка

        for (int i = 0; i < minList; i++) { // цикъл за смесване последователно елементите от двата списъка
            int first = firstList.get(i);
            int second = secondsList.get(i);

            resultList.add(first);
            resultList.add(second);
        }
        // долепяне на поредицата крайни елементи от по-дългия списък към resultList
        if (firstList.size() > secondsList.size()){
            resultList.addAll(firstList.subList(minList, firstList.size()));
        }else {
            resultList.addAll(secondsList.subList(minList, secondsList.size()));
        }

        System.out.println(resultList.toString().replaceAll("[\\[\\],]", ""));
    }
}
