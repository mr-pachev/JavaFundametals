package MoreExer_05;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstNumsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondNumsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(secondNumsList);

        List<Integer> resultList = new ArrayList<>();

        int biggerListSize = biggerList(firstNumsList, secondNumsList).size();
        int startIndex = 0;
        int endIndex = 0;

        for (int index = 0; index <= biggerListSize - 1; index++) { //обхождане на най-големия лист
            if (index < biggerListSize -2 && index < biggerListSize - 1) { //обхождане на biggerList без последните два елеменга
                    resultList.add(firstNumsList.get(index));
                    resultList.add(secondNumsList.get(index));
            }else if (index == biggerListSize - 2){ //начало на диапазона
                startIndex = biggerList(firstNumsList, secondNumsList).get(index);
            }else if (index == biggerListSize - 1){ //край на диапазона
                endIndex = biggerList(firstNumsList, secondNumsList).get(index);
            }
        }
        int startElement = 0;
        int endElement  = 0;
        startElement = Math.min(startIndex, endIndex);
        endElement = Math.max(startIndex, endIndex);
        Collections.sort(resultList);

      for (int element : resultList){
          if (element > startElement && element < endElement) {
              System.out.printf("%d ", element);
          }
      }

    }
    //проверка за по-големия списък
    public static List<Integer> biggerList (List<Integer> listOne, List<Integer> listTwo) {
        if (listOne.size() >= listTwo.size()) {
            return listOne;
        }
        return listTwo;
    }

}
