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

        int countFullVagons = 0; //брояч пълни вагони

        for (int indexArr = 0; indexArr <= liftArray.length - 1; indexArr++) { //обхождаме всеки вагон
            int neededPeople = 0; //нужни хора за запълванена дадения вагон

            if (liftArray[indexArr] < 4) { //проверка дали вагона е запълнен
                neededPeople = 4 - liftArray[indexArr]; //намиране колко хора са нужни за запълване на вагона

                if (peopleStay > 0) { //проверка дали има хора да се качват

                    if (peopleStay >= neededPeople) { //запълване на вагона
                        liftArray[indexArr] = 4;
                        peopleStay -= neededPeople;
                        countFullVagons++;
                    } else {
                        liftArray[indexArr] += peopleStay;
                        peopleStay -= peopleStay;
                    }
                }
            } else {
                countFullVagons++;
            }
        }

        if (countFullVagons == liftArray.length) { //проверка дали лифта е пълен

            if (peopleStay <= 0) { //проверка дали има чакащи хора
                System.out.println(liftArr(liftArray));
            } else {
                System.out.printf("There isn't enough space! %d people in a queue!%n", peopleStay);
                System.out.println(liftArr(liftArray));
            }
        } else {
            System.out.println("The lift has empty spots!");
            System.out.println(liftArr(liftArray));
        }

    }

    public static String liftArr(int[] lift) {
        String result = "";
        for (int vagon : lift) {
            result += vagon + " ";
        }
        return result;
    }
}
