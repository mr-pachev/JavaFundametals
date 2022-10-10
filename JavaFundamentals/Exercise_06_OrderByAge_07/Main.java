package Exercise_06_OrderByAge_07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String personData = scanner.nextLine();
        List<PersonData> personDataList = new ArrayList<>();

        while (!personData.equals("End")){
            String firstName = personData.split(" ")[0];
            String id = personData.split(" ")[1];
            int age = Integer.parseInt(personData.split(" ")[2]);
            PersonData person = new PersonData(firstName, id, age);

            personDataList.add(person);
            personData = scanner.nextLine();
        }
        personDataList.sort(Comparator.comparingInt(PersonData::getAge));
        for (PersonData items : personDataList){
            System.out.println(items.toString());
        }
    }
}
