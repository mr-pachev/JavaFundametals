package MidExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.sort(numbersList);
        Collections.reverse(numbersList);

        double averageValue = valueAverage(numbersList); //средната стойност на сумата от елементите на numList
        List<Integer> resultList = new ArrayList<>();

        for (int indexList = 0; indexList <= numbersList.size() - 1; indexList++) { //обхождаме numList
            int currentElement = numbersList.get(indexList);

            if (currentElement > averageValue){ //проверка дали текущия елемент отговаря  на условието
                resultList.add(currentElement);
            }
        }

        if (resultList.isEmpty()){
            System.out.println("No");
        }else {
            System.out.println(listElement(resultList));
        }

    }

    //намиране средната стойност от сбора на елементите от масива
    public static Double valueAverage (List<Integer> exampleList){
       double result = 0;
        for (int index = 0; index <= exampleList.size() - 1; index++) {
            result += exampleList.get(index);
        }
        result = result / exampleList.size();
        return result;
    }

    //готовия резултат за принтиране
    public static String listElement (List<Integer> printList){
        String result = "";
        for (int i = 0; i <= printList.size() -1; i++) {

            if (i <= 4){
                result += printList.get(i) + " ";
            }
        }
        return result;
    }
}
