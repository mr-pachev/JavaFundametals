package Exercise_06_OpinionPoll_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String incomming = scanner.nextLine();

            String name = incomming.split(" ")[0];
            int age = Integer.parseInt(incomming.split(" ")[1]);

            Person person = new Person(name, age);
            personList.add(person);
        }
        for (Person items : personList) {
            if (items.getAge() > 30) {
                System.out.println(items.toString());
            }
        }
    }
}