package MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String command = input.split(" ")[0];


            switch (command) {
                case "Shoot":
                    int indexShoot = Integer.parseInt(input.split(" ")[1]);
                    int power = Integer.parseInt(input.split(" ")[2]);

                    if (isValid(numbersList, indexShoot)) {
                        int current = numbersList.get(indexShoot) - power;
                        if (current <= 0) {
                            numbersList.remove(indexShoot);
                        } else {
                            numbersList.set(indexShoot, current);
                        }
                    }

                    break;
                case "Add":
                    int indexAdd = Integer.parseInt(input.split(" ")[1]);
                    int value = Integer.parseInt(input.split(" ")[2]);
                    if (isValid(numbersList, indexAdd)) {
                        numbersList.add(indexAdd, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }

                    break;
                case "Strike":
                    int indexStrike = Integer.parseInt(input.split(" ")[1]);
                    int radius = Integer.parseInt(input.split(" ")[2]);

                    boolean isTrue = numbersList.size() - 1 >= indexStrike && numbersList.size() - 1 >= indexStrike + radius
                            && indexStrike - radius >= 0;
                    if (isTrue) {
                        for (int i = 0; i < radius * 2 + 1; i++) {
                            numbersList.remove(indexStrike - radius);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(numbersList.toString()
                        .replace("[", "") // замества символа '[' с 'интервал'
                        .replace("]", "") // замества символа ']' с 'интервал'
                        .trim() // премахва интервала в началото и/или края
                        .replaceAll(",", "") // замества "," с "" - премахва запетайките
                        .replaceAll(" ", "\\|"));
    }

    public static boolean isValid(List<Integer> inConsole, int index) {
        return index >= 0 && index <= inConsole.size()-1;

    }
}
