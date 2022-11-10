package MidExamPreparation;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class TheLift_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int peopleStay = Integer.parseInt(scanner.nextLine()); //чакащи хора за лифта
        int[] liftArray = Arrays.stream(scanner.nextLine() //лифта и хората в него
                                .split(" "))
                                .mapToInt(Integer::parseInt)
                                 .toArray();

        for (int indexArr = 0; indexArr <= liftArray.length - 1; indexArr++) { //обхождаме всеки вагон
            int neededPeople = 0; //нужни хора за запълванена дадения вагон

            if (liftArray[indexArr] < 4){ //проверка дали вагона е запълнен
                neededPeople = 4 - liftArray[indexArr]; //намиране колко хора са нужни за запълване на вагона

                if (peopleStay > 0){ //проверка дали има хора да се качват

                    if (peopleStay >= neededPeople) { //запълване на вагона
                        liftArray[indexArr] = 4;
                        peopleStay -= neededPeople;
                    }else {
                        liftArray[indexArr] += peopleStay;
                        peopleStay -= peopleStay;
                    }
                }
            }

        }
    }
}
