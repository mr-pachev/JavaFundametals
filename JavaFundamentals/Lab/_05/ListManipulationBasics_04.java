package Lab._05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")){ // цикъл до достигане на String = "end"
            List<String> comanLine = Arrays.stream(input.split(" ")).collect(Collectors.toList()); // списък с входящите елементи

           String command = comanLine.get(0); // елемнта от списъка с входящи данни с индекс 0 е командата
           int number = 0;
           int index = 0;

           switch (command){
               case "Add":
            number = Integer.parseInt(comanLine.get(1));
            numbersList.add(number);
                   break;
               case "Remove":
            number = Integer.parseInt(comanLine.get(1));
            numbersList.remove(Integer.valueOf(number));
                   break;
               case "RemoveAt":
            index = Integer.parseInt(comanLine.get(1));
            numbersList.remove(index);
                   break;
               case "Insert":
                   number = Integer.parseInt(comanLine.get(1));
                   index = Integer.parseInt(comanLine.get(2));
                   numbersList.add(index, number);
                   break;
           }

            input = scanner.nextLine();
        }
        System.out.println(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }
}
