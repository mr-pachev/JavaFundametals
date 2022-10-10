package Exercises._03;

import java.util.Scanner;

public class CommonElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split(" ");// въвеждане масив тип стринг от конзолата по разделите Space
        String[] secondArr = scanner.nextLine().split(" ");// въвеждане масив тип стринг от конзолата по разделите Space

        for (String secondCurrent : secondArr) {//foreach цикъл за обхождане на всеки елемент от secondArr масива без да можем да го променяме
            for (String firstCurrent : firstArr) {//foreach цикъл за обхождане на всеки елемент от firstArr масива без да можем да го променяме
                if (secondCurrent.equals(firstCurrent)) {// сравнение на текущите елементи от двата васива
                    System.out.print(secondCurrent + " ");
                }
            }
        }
    }
}
