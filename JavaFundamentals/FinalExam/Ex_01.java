package FinalExam;

import java.util.Scanner;

public class Ex_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Finish")) {
            String operation = command.split(" ")[0];

            for (int i = 0; i < input.length(); i++) {

            }


            if (command.contains("Replace")){

            }else if(command.contains("Cut")){

            }else if(command.contains("Make")){

            }else if(command.contains("Check")){

            }else if(command.contains("Sum")){

            }

                command = scanner.nextLine();
        }

    }
}
