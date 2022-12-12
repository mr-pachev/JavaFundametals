package MoreExerCarSalesman_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //брой редове с двигатели

        List<Car> car = new ArrayList<>();

        for (int currentEngine = 0; currentEngine <= n; currentEngine++) {
            String[] inpputArr = scanner.nextLine().split(" "); //масив с входящата информация

            String engineModel = inpputArr[0]; //модел на двигателя
            int power = Integer.parseInt(inpputArr[1]); //мощност на двигателя
            String  displacement = ""; //работен обем
            int displacementInt = 0;
            String efficiency = ""; //ефективност на двигателя
            int efficiencyInt = 0;

            if (inpputArr.length < 3){ //проверка дали има подадени робетен обем и ефективност на двигателя
                displacement = "n/a";
                efficiency = "n/a";
            }else {
               displacementInt = Integer.parseInt(inpputArr[2]);
               efficiencyInt = Integer.parseInt(inpputArr[3]);
            }


        }

    }
}
