package MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhoneShop_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phoneList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String command = input.split(" ")[0];

            switch (command) {
                case "Add":
                    String phoneAdd = input.split(" ")[2];
                    if (phoneList.contains(phoneAdd)) {
                        break;
                    } else {
                        phoneList.add(phoneAdd);
                    }
                    break;

                case "Remove":
                    String phoneRemove = input.split(" ")[2];
                    if (phoneList.contains(phoneRemove)) {
                        phoneList.remove(phoneRemove);
                    } else {
                        break;
                    }
                    break;

                case "Bonus":
                    String phone = input.split(" ")[3];
                    String oldPhone = phone.split(":")[0];
                    String newPhone = phone.split(":")[1];
                    if (phoneList.contains(oldPhone)) {
                        phoneList.add(newPhone);
                    } else {
                        break;
                    }
                    break;

                case "Last":
                    String phoneLast = input.split(" ")[2];
                    if (phoneList.contains(phoneLast)) {
                        phoneList.remove(phoneLast);
                        phoneList.add(phoneLast);
                    } else {
                        break;
                    }
                    break;

            }

            input = scanner.nextLine();
        }

        System.out.print(phoneList.toString()
                .replace("[", "")
                .replace("]", ""));


    }
}

